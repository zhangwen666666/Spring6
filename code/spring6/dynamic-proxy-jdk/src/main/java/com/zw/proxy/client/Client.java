package com.zw.proxy.client;

import com.zw.proxy.service.OrderService;
import com.zw.proxy.service.OrderServiceImpl;
import com.zw.proxy.service.TimerInvocationHandler;

import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        // 创建目标对象
        OrderService target = new OrderServiceImpl();
        // 创建代理对象
        /*
            Object proxyObj = Proxy.newProxyInstance(类加载器, 代理类要实现的接口, 调用处理器);
            1. newProxyInstance：新建代理对象，通过调用这个方法可以创建代理对象。
            2. 本质上，Proxy.newProxyInstance()方法的执行做了两件事：
                (1) 在内存中动态的生成了一个代理类的字节码class
                (2) new对象了，通过内存中生成的这个class字节码，实例化了代理对象。
            3. 关于newProxyInstance方法的三个重要参数

         */

        // 调用代理对象的代理方法
        Object proxyObj = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new TimerInvocationHandler(target));
        OrderService proxy = (OrderService) proxyObj;
        proxy.generate();
        proxy.modify();
        proxy.detail();
        String name = proxy.getName();
        System.out.println(name);
    }
}
