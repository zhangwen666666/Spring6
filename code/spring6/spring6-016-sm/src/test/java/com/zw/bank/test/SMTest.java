package com.zw.bank.test;

import com.zw.bank.config.Spring6Config;
import com.zw.bank.exceptions.AccountNotExistException;
import com.zw.bank.exceptions.MoneyNotEnoughException;
import com.zw.bank.exceptions.TransferException;
import com.zw.bank.pojo.Account;
import com.zw.bank.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:spring.xml")
public class SMTest {
//    @Autowired
//    private AccountService accountService;

//    @Test
//    public void testSM(){
//        try {
//            accountService.transfer("act-001","act-002", 10000.0);
//        } catch (Exception e) {
//            System.out.println("转账失败");
//        }
//    }

    @Test
    public void test1(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Spring6Config.class);
        AccountService accountService1 = applicationContext.getBean("accountService", AccountService.class);
        List<Account> accounts =  accountService1.getAll();
        System.out.println(accounts);
    }
}
