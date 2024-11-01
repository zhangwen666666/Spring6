package com.zw.proxy.service;

public class OrderServiceImpl implements OrderService{
    @Override
    public String getName() {
        System.out.println("getName()方法执行了");
        return "张三";
    }

    @Override
    public void generate() {
        // 模拟生成订单的耗时
        try {
            Thread.sleep(1234);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("订单已生成");
    }

    @Override
    public void modify() {
        // 模拟修改订单耗时
        try {
            Thread.sleep(1111);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("订单已修改");
    }

    @Override
    public void detail() {
        // 模拟查看订单耗时
        try {
            Thread.sleep(1452);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("请查看订单详情");
    }
}
