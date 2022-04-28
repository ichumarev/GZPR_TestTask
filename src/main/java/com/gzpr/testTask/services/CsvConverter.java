package com.gzpr.testTask.services;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import com.gzpr.testTask.Models.ApiUser;
import org.springframework.stereotype.Service;

@Service
public class CsvConverter {

    public static void CollectionToCsv(final Collection<ApiUser> users, File csvFile) throws IOException {
        try (PrintWriter pw = new PrintWriter(csvFile)) {
            users.stream()
                    .map(ApiUser::convertToCSV)
                    .forEach(pw::println);
        }
    }
}
