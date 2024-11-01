package com.zw.proxy.service;

public class UserService {
    public boolean login(String username, String password){
        System.out.println("系统正在验证身份...");
        if ("admin".equals(username) && "123".equals(password)) {
            return true;
        }
        return false;
    }

    public void logout(){
        System.out.println("退出系统...");
    }
}
