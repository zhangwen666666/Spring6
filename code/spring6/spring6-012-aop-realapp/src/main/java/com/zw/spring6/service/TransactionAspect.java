package com.zw.spring6.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component("transactionAspect")
public class TransactionAspect {
    @Around("execution(* com.zw.spring6.service..*(..))")
    public void aroundAdvice(ProceedingJoinPoint joinPoint){
        try {
            // 前环绕
            System.out.println("开启事务");
            joinPoint.proceed();
            // 后环绕
            System.out.println("提交事务");
        } catch (Throwable e) {
            System.out.println("回滚事务");
        }
    }
}
