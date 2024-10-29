package com.zw.spring6.bean;

import java.util.Arrays;

public class Teacher {
    private String[] hobbies;
    public Clazz[] clazzes;

    @Override
    public String toString() {
        return "Teacher{" +
                "hobbies=" + Arrays.toString(hobbies) +
                ", clazzes=" + Arrays.toString(clazzes) +
                '}';
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    public void setClazzes(Clazz[] clazzes) {
        this.clazzes = clazzes;
    }
}
