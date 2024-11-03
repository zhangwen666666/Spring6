package com.zw.spring6.service;

import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountService {
    public void transfer(){
        System.out.println("银行账户正在完成转账操作");
    }

    public void withdraw(){
        System.out.println("银行账户正在取款，请稍后...");
    }
}
