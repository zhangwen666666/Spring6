package com.zw.spring6.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FirstSpringTest {
    @Test
    public void testFirstSpringCode(){
        // 1. 获取Spring容器对象。
        String path = "spring.xml";   // spring配置文件的路径
        // ApplicationContext是一个接口，下面有很多实现类
        // ClassPathXmlApplicationContext 专门从类路径中加载spring配置文件的一个Spring上下文对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(path);

        // 2. 根据bean的id从Spring容器中获取这个对象
        Object userBean = applicationContext.getBean("userBean");
        System.out.println(userBean); //com.zw.spring6.bean.User@6cf0e0ba

        Object userDaoBean = applicationContext.getBean("userDaoBean");
        System.out.println(userDaoBean);

        Logger logger = LoggerFactory.getLogger(FirstSpringTest.class);
        logger.info("一条信息");
        logger.debug("debug信息");
        logger.error("错误信息");
    }
}
