package com.zw.spring6.service;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component("securityAspect")
@Order(3)
public class SecurityAspect {
    // 通知 + 切点
    @Before("execution(* com.zw.spring6.service..*(..))")
    public void beforeAdvice(){
        System.out.println("安全前置通知");
    }
}
