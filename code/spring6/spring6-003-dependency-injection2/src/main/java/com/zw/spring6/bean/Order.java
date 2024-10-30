package com.zw.spring6.bean;

import java.util.Map;
import java.util.Properties;

public class Order {
    private Map<Integer, String> orders;
    private Properties properties;

    public void setOrders(Map<Integer, String> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orders=" + orders +
                ", properties=" + properties +
                '}';
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

}
