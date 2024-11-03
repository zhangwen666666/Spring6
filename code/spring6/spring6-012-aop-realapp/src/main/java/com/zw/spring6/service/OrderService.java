package com.zw.spring6.service;

import org.springframework.stereotype.Service;

@Service("orderService")
public class OrderService {
    public void generate(){
        System.out.println("正在生成订单");
        System.out.println(1/0);
    }

    public void cancel(){
        System.out.println("订单已取消");
    }
}
