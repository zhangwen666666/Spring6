package com.zw.spring6.bean;

import java.util.Date;

public class Dog {
    // 简单类型
    private String name;
    private int age;
    // 非简单类型
    private Date birth;

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birth=" + birth +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }
}
