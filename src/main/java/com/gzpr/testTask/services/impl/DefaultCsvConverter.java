package com.gzpr.testTask.services.impl;

import com.gzpr.testTask.Models.ApiUser;
import com.gzpr.testTask.services.CsvConverter;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

@Component
public class DefaultCsvConverter implements CsvConverter {

    public void CollectionToCsv(final Collection<ApiUser> users, final File csvFile) throws IOException {
        try (PrintWriter pw = new PrintWriter(csvFile)) {
            users.stream()
                    .map(ApiUser::convertToCSV)
                    .forEach(pw::println);
        }
    }
}
