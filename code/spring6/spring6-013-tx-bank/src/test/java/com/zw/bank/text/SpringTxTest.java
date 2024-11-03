package com.zw.bank.text;

import com.zw.bank.exceptions.AccountNotExistException;
import com.zw.bank.exceptions.MoneyNotEnoughException;
import com.zw.bank.exceptions.TransferException;
import com.zw.bank.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTxTest {
    @Test
    public void testTx(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        try {
            accountService.transfer("act001", "act002", 10000.0);
            System.out.println("转账成功");
        } catch (Exception e) {
            System.out.println("转账失败");;
        }
    }
}
