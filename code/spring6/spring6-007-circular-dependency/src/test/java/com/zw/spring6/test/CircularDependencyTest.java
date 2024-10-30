package com.zw.spring6.test;

import com.zw.spring6.bean.Husband;
import com.zw.spring6.bean.Wife;
import com.zw.spring6.bean2.Husband2;
import com.zw.spring6.bean2.Wife2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CircularDependencyTest {
    @Test
    public void testCD(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Husband husbandBean = applicationContext.getBean("husbandBean", Husband.class);
        Wife wifeBean = applicationContext.getBean("wifeBean", Wife.class);
        System.out.println(husbandBean);
        System.out.println(wifeBean);
    }

    @Test
    public void testCD2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring2.xml");
        Husband2 husbandBean = applicationContext.getBean("husbandBean", Husband2.class);
        Wife2 wifeBean = applicationContext.getBean("wifeBean", Wife2.class);
        System.out.println(husbandBean);
        System.out.println(wifeBean);
    }
}
