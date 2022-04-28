package com.gzpr.testTask.Models;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;

public class ApiResponse implements Serializable {

    private Collection<ApiUser> results;
    private HashMap<String, Object> info;

    public ApiResponse(Collection<ApiUser> results, HashMap<String, Object> info) {
        this.results = results;
        this.info = info;
    }

    public Collection<ApiUser> getResults() {
        return results;
    }

    public void setResults(Collection<ApiUser> results) {
        this.results = results;
    }

    public HashMap<String, Object> getInfo() {
        return info;
    }

    public void setInfo(HashMap<String, Object> info) {
        this.info = info;
    }
}
