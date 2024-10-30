package com.zw.spring6.bean;

import java.util.Date;

public class Student {
    private Date birth;

    @Override
    public String toString() {
        return "Student{" +
                "birth=" + birth +
                '}';
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }
}
