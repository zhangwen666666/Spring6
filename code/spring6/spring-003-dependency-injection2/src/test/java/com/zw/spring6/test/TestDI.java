package com.zw.spring6.test;

import com.zw.spring6.action.UserAction;
import com.zw.spring6.bean.*;
import com.zw.spring6.jdbc.MyDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDI {
    @org.junit.Test
    public void testSet(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-useraciton.xml");
/*        UserAction userAction = applicationContext.getBean("userAction", UserAction.class);
        userAction.service();*/

        UserAction userAction = applicationContext.getBean("ua", UserAction.class);
        userAction.service();
    }

    @Test
    public void testEasy(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-easy.xml");
        User user = applicationContext.getBean("user", User.class);
        System.out.println(user);

        MyDataSource myDataSource = applicationContext.getBean("myDataSource", MyDataSource.class);
        System.out.println(myDataSource);
    }

    @Test
    public void testCascade(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-cascade.xml");
        Student student = applicationContext.getBean("student", Student.class);
        System.out.println(student);

        Student student1 = applicationContext.getBean("student1", Student.class);
        System.out.println(student1);
    }

    @Test
    public void testSetArray(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-array.xml");
        Teacher teacher = applicationContext.getBean("teacher", Teacher.class);
        System.out.println(teacher);
    }

    @Test
    public void testListAndSet(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-list-set.xml");
        Person person = applicationContext.getBean("person", Person.class);
        System.out.println(person);
    }

    @Test
    public void testMapAndProperties(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-map-properties.xml");
        Order order = applicationContext.getBean("order", Order.class);
        System.out.println(order);
    }

    @Test
    public void testNull(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-null.xml");
        Vip vip1 = applicationContext.getBean("vip1", Vip.class);
        // System.out.println(vip1.getEmail().toString());
        Vip vip2 = applicationContext.getBean("vip2", Vip.class);
        System.out.println(vip2.getEmail().toString());
    }
}
