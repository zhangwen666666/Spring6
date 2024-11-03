package com.zw.spring6.biz;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.zw.spring6.biz")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class LogConfig {
}
