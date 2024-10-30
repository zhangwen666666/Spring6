package com.zw.myspring.test;

import com.zw.myspring.bean.UserService;
import org.junit.Test;
import org.myspringframework.core.ApplicationContext;
import org.myspringframework.core.ClassPathXmlApplicationContext;

public class MySpringTest {
    @Test
    public void testMySpring(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("myspring.xml");
        Object user = applicationContext.getBean("user");
        System.out.println(user);
        Object userService = applicationContext.getBean("userService");
        UserService service = (UserService) userService;
        service.save();
    }
}
