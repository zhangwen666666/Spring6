package com.zw.proxy.client;

import com.zw.proxy.service.OrderService;
import com.zw.proxy.service.OrderServiceImpl;
import com.zw.proxy.service.OrderServiceImplSub;
import com.zw.proxy.service.OrderServiceProxy;

public class Test {
    public static void main(String[] args) {
        /*OrderService orderService = new OrderServiceImpl();
        orderService.generate();
        orderService.modify();
        orderService.detail();*/

        /*OrderService orderService = new OrderServiceImplSub() ;
        orderService.generate();
        orderService.modify();
        orderService.detail();*/

        // 目标对象
        OrderService target = new OrderServiceImpl();
        // 代理对象
        OrderService proxy = new OrderServiceProxy(target);
        proxy.generate();
        proxy.modify();
        proxy.detail();
    }
}
