package com.zw.proxy.service;

public class OrderServiceProxy implements OrderService {

    // 将目标对象做为代理对象的一个属性，这种关系叫做关联关系，比继承关系耦合度低
    // 代理对象中含有目标对象的引用，关联关系
    // 注意：这里要写一个公共接口类型，因为公共接口耦合度低
    private OrderService target; // 目标对象

    public OrderServiceProxy(OrderService target) {
        this.target = target;
    }

    @Override
    public void generate() {
        long begin = System.currentTimeMillis();
        target.generate();
        long end = System.currentTimeMillis();
        System.out.println("耗时" + (end - begin) + "毫秒");
    }

    @Override
    public void modify() {
        long begin = System.currentTimeMillis();
        target.modify();
        long end = System.currentTimeMillis();
        System.out.println("耗时" + (end - begin) + "毫秒");
    }

    @Override
    public void detail() {
        long begin = System.currentTimeMillis();
        target.detail();
        long end = System.currentTimeMillis();
        System.out.println("耗时" + (end - begin) + "毫秒");
    }
}
