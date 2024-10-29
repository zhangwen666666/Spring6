package com.zw.spring6.service;

import com.zw.spring6.dao.OrderDao;

public class OrderService {
    private OrderDao orderDao;

    public void setXxxx(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void generate(){
        orderDao.generate();
    }
}
