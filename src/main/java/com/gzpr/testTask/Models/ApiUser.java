package com.gzpr.testTask.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
public class ApiUser implements Serializable {

    private String gender;
    private String email;
    private UserName name;

    public static String convertToCSV(ApiUser user) {
        return user.toString();
    }

    @Override
    public String toString() {
        return gender + "," + email + "," + name;
    }
}
