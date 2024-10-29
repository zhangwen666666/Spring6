package com.zw.spring6.bean;

import java.util.Date;

public class People {
    private String name;
    private int age;
    private boolean sex;

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }

    public People(String name, int age, boolean sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
}
