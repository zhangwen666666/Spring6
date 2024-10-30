package com.zw.spring6.bean2;

public class Wife2 {
    private String name;
    private Husband2 husband;

    @Override
    public String toString() {
        return "Wife{" +
                "name='" + name + '\'' +
                ", husband=" + husband.getName() +
                '}';
    }

    public Wife2(String name, Husband2 husband) {
        this.name = name;
        this.husband = husband;
    }

    public String getName() {
        return name;
    }
}
