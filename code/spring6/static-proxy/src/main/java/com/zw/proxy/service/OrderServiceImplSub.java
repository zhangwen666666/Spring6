package com.zw.proxy.service;

public class OrderServiceImplSub extends OrderServiceImpl {
    @Override
    public void generate() {
        long start = System.currentTimeMillis();
        super.generate();
        long end = System.currentTimeMillis();
        System.out.println("耗时" + (end - start) + "毫秒");
    }

    @Override
    public void modify() {
        long start = System.currentTimeMillis();
        super.modify();
        long end = System.currentTimeMillis();
        System.out.println("耗时" + (end - start) + "毫秒");
    }

    @Override
    public void detail() {
        long start = System.currentTimeMillis();
        super.detail();
        long end = System.currentTimeMillis();
        System.out.println("耗时" + (end - start) + "毫秒");
    }
}
