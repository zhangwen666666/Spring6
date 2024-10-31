package com.zw.spring6.test;

import com.zw.spring6.bean.Order;
import com.zw.spring6.bean.Student;
import com.zw.spring6.bean.User;
import com.zw.spring6.bean.Vip;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IoCAnnotationTest {
    @Test
    public void test1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        User user = applicationContext.getBean("userBean", User.class);
        System.out.println(user);
        Vip vipBean = applicationContext.getBean("vipBean", Vip.class);
        System.out.println(vipBean);
        Order order = applicationContext.getBean("orderBean", Order.class);
        System.out.println(order);
        Student student = applicationContext.getBean("studentBean", Student.class);
        System.out.println(student);
    }
}
