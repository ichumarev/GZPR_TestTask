package com.gzpr.testTask.Models;

import java.io.Serializable;

public class ApiUser implements Serializable {

    private String gender;
    private String email;
    private UserName name;

    public ApiUser(String gender, String email, UserName name) {
        this.gender = gender;
        this.email = email;
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserName getName() {
        return name;
    }

    public void setName(UserName name) {
        this.name = name;
    }

    public static String convertToCSV(ApiUser user) {
        return user.toString();
    }

    @Override
    public String toString() {
        return gender + "," + email + "," + name;
    }
}
