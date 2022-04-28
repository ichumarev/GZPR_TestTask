package com.gzpr.testTask;

import com.gzpr.testTask.Models.ApiResponse;
import com.gzpr.testTask.services.CsvConverter;
import com.gzpr.testTask.services.RestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

@SpringBootApplication
public class TestTaskApplication implements CommandLineRunner {

	private static final String EXTENSION = ".csv";

	private static final Logger LOG = LoggerFactory.getLogger(TestTaskApplication.class);

	private final RestService restService;
	@Autowired
	private final CsvConverter csvConverter;

	public TestTaskApplication(RestService restService, CsvConverter csvConverter) {
		this.restService = restService;
		this.csvConverter = csvConverter;
	}

	public static void main(String[] args) {
		LOG.info("STARTING THE APPLICATION");
		SpringApplication.run(TestTaskApplication.class, args);
		LOG.info("APPLICATION FINISHED");
	}

	@Override
	public void run(final String... args) {
		LOG.info("EXECUTING : command line runner");

		if (isNotContainTwoArgs(args)) {
			return;
		}

		final String numberOfRows = args[0];
		final String fileName = args[1];
		ApiResponse apiResponse = null;

		try {
			apiResponse =  restService.getJSON(numberOfRows);
		} catch (Exception e) {
			LOG.error("Error with request to API.");
			e.printStackTrace();
		}

		if (Objects.isNull(apiResponse) || apiResponse.getResults().size() == 0) {
			LOG.error("No rows for writing.");
			return;
		}

		File csvFile = new File(fileName + EXTENSION);
		try {
			csvConverter.CollectionToCsv(apiResponse.getResults(), csvFile);
		} catch (IOException e) {
			LOG.error("Error with converting from JSON to CSV.");
			e.printStackTrace();
		}
	}

	private boolean isNotContainTwoArgs(final String... args) {
		if (args.length != 2) {
			LOG.info("Please input two args!");
			return true;
		}
		return false;
	}
}
