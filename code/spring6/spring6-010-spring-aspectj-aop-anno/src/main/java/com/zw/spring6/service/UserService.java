package com.zw.spring6.service;

import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {
    public void login(){
        System.out.println("系统正在进行身份认证...");
    }

    public void logout(){
        System.out.println("退出系统....");
    }
}
