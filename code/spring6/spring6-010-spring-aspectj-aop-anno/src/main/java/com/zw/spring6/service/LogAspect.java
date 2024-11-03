package com.zw.spring6.service;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component("logAspect")
@Order(2)
public class LogAspect {
    // 切面 = 通知 + 切点
    @Before("execution(* com.zw.spring6.service.UserService.*(..))")
    public void zq(){
        System.out.println("增强");
    }
}
