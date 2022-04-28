package com.gzpr.testTask.services;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import com.gzpr.testTask.Models.ApiUser;

public interface CsvConverter {
    void CollectionToCsv(Collection<ApiUser> users, File csvFile) throws IOException;
}
