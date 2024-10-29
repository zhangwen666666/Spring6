package com.zw.spring6.bean;

public class Address {
    private String city;

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                '}';
    }

    public void setCity(String city) {
        this.city = city;
    }
}
