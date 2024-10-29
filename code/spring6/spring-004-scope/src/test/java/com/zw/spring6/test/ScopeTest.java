package com.zw.spring6.test;

import com.zw.spring6.bean.SpringBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeTest {
    @Test
    public void testBeanScope(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-scope.xml");
        SpringBean sb = applicationContext.getBean("sb", SpringBean.class);
        System.out.println(sb);

        SpringBean sb2 = applicationContext.getBean("sb", SpringBean.class);
        System.out.println(sb2);

        SpringBean sb3 = applicationContext.getBean("sb", SpringBean.class);
        System.out.println(sb3);
    }

    @Test
    public void testThreadScope(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-scope.xml");
        SpringBean sb = applicationContext.getBean("sb", SpringBean.class);
        System.out.println(Thread.currentThread().getName() + sb);
        SpringBean sb1 = applicationContext.getBean("sb", SpringBean.class);
        System.out.println(Thread.currentThread().getName() + sb1);

        new Thread(() -> {
            SpringBean sb2 = applicationContext.getBean("sb", SpringBean.class);
            System.out.println(Thread.currentThread().getName() + sb2);
            SpringBean sb3 = applicationContext.getBean("sb", SpringBean.class);
            System.out.println(Thread.currentThread().getName() + sb3);
        }).start();
    }
}
