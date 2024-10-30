package com.zw.myspring.bean;

public class User {
    private String name;
    private int age;
    private Integer num;
    private Boolean sex;

    public void setNum(Integer num) {
        this.num = num;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", num=" + num +
                ", sex=" + sex +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
