package com.zw.spring6.test;

import com.zw.spring6.biz.LogConfig;
import com.zw.spring6.biz.UserService;
import com.zw.spring6.biz.VipService;
import com.zw.spring6.service.AccountService;
import com.zw.spring6.service.OrderService;
import com.zw.spring6.service.Spring6Config;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppTest {
    @Test
    public void testAOP(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Spring6Config.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        orderService.generate();
        orderService.cancel();
        accountService.transfer();
        accountService.withdraw();
    }

    @Test
    public void test1(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(LogConfig.class);
        VipService vipService = applicationContext.getBean("vipService", VipService.class);
        vipService.saveVip();
        vipService.deleteVip();
        vipService.modifyVip();
        vipService.getVip();

        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.saveUser();
        userService.deleteUser();
        userService.modifyUser();
        userService.getUser();
    }
}
