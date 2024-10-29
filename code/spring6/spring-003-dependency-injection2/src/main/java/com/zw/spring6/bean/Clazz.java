package com.zw.spring6.bean;

public class Clazz {
    private String cname;

    @Override
    public String toString() {
        return "Clazz{" +
                "cname='" + cname + '\'' +
                '}';
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
