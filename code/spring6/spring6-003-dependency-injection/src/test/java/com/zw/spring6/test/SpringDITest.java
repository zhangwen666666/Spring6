package com.zw.spring6.test;

import com.zw.spring6.bean.*;
import com.zw.spring6.jdbc.MyDataSource1;
import com.zw.spring6.jdbc.MyDataSource2;
import com.zw.spring6.service.CustomerService;
import com.zw.spring6.service.OrderService;
import com.zw.spring6.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class SpringDITest {
    @Test
    public void testSetDI(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        UserService userServiceBean = applicationContext.getBean("userServiceBean", UserService.class);
        userServiceBean.saveUser();
    }

    @Test
    public void testConstructor(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        CustomerService csBean = applicationContext.getBean("csBean", CustomerService.class);
        csBean.save();


        CustomerService csBean2 = applicationContext.getBean("csBean2", CustomerService.class);
        csBean2.save();
    }

    @Test
    public void testSetDI2(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");
        OrderService orderServiceBean = applicationContext.getBean("orderServiceBean", OrderService.class);
        orderServiceBean.generate();

        OrderService orderServiceBean2 = applicationContext.getBean("orderServiceBean2", OrderService.class);
        orderServiceBean2.generate();
    }

    @Test
    public void testSimpleTypeSet(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");
        User user = applicationContext.getBean("userBean", User.class);
        System.out.println(user);

        System.out.println(new Date());

        Date dateBean = applicationContext.getBean("dateBean", Date.class);
        System.out.println(dateBean);
    }

    @Test
    public void testSetArray(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-array.xml");
        QianDaYe yuqian = applicationContext.getBean("yuqian", QianDaYe.class);
        System.out.println(yuqian);
    }

    @Test
    public void testSetListAndSet(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-list.xml");
        Person person = applicationContext.getBean("person", Person.class);
        System.out.println(person);
    }

    @Test
    public void testP(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-p.xml");
        Dog dogBean = applicationContext.getBean("dogBean", Dog.class);
        System.out.println(dogBean);
    }

    @Test
    public void testC(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-c.xml");
        People people = applicationContext.getBean("people", People.class);
        System.out.println(people);
    }

    @Test
    public void testUtil(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-data-source.xml");
        MyDataSource1 ds1 = applicationContext.getBean("ds1", MyDataSource1.class);
        System.out.println(ds1);
        MyDataSource2 ds2 = applicationContext.getBean("ds2", MyDataSource2.class);
        System.out.println(ds2);
    }

    @Test
    public void testAutoWire(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-autowire.xml");
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        orderService.generate();
    }

    @Test
    public void testContext(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-properties.xml");
        MyDataSource1 ds = applicationContext.getBean("ds", MyDataSource1.class);
        System.out.println(ds);
    }
}
