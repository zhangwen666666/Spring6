package com.zw.spring6.web;

import com.zw.spring6.service.UserService;
import com.zw.spring6.service.impl.UserServiceImpl;

public class UserAction {
    // private UserService userService = new UserServiceImpl();

    private UserService userService;

    public void deleteRequest(){
        userService.deleteUser();
    }
}
