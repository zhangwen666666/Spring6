package com.zw.spring6.bean;

import java.util.Objects;

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

    @Override
    public boolean equals(Object object) {
        System.out.println("equals方法执行了");
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Address address = (Address) object;
        return Objects.equals(city, address.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city);
    }
}
