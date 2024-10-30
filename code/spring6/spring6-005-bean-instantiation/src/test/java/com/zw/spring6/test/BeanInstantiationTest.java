package com.zw.spring6.test;

import com.zw.spring6.bean.SpringBean;
import com.zw.spring6.bean.Star;
import com.zw.spring6.bean.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class BeanInstantiationTest {
    @Test
    public void testInstant1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        SpringBean sb = applicationContext.getBean("sb", SpringBean.class);
        System.out.println(sb);
    }

    @Test
    public void testInstant2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Star starBean = applicationContext.getBean("starBean", Star.class);
        System.out.println(starBean);
        // System.out.println(new Date());
    }

    @Test
    public void testDate(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Student student = applicationContext.getBean("student", Student.class);
        System.out.println(student);

        Student student1 = applicationContext.getBean("student1", Student.class);
        System.out.println(student1);
    }
}
