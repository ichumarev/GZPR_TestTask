package com.gzpr.testTask.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
public class UserName implements Serializable {
    private String title;
    private String first;
    private String last;

    @Override
    public String toString() {
        return title + "," + first + "," + last;
    }
}
