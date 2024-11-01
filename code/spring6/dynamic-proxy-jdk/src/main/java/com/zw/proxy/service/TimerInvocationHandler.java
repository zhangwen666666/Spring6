package com.zw.proxy.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TimerInvocationHandler implements InvocationHandler {

    private Object target;

    public TimerInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long begin = System.currentTimeMillis();
        // System.out.println("增强1...");
        Object retValue = method.invoke(target, args);
        // System.out.println("增强2...");
        long end = System.currentTimeMillis();
        System.out.println("耗时" + (end - begin) + "毫秒");
        return retValue;
    }
}
