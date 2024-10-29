package com.zw.spring6.action;

import com.zw.spring6.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserAction {
    private UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(UserAction.class);

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public UserAction() {
    }

    public UserAction(UserService userService) {
        this.userService = userService;
    }

    public void service(){
        logger.info("开启服务");
        userService.save();
        logger.info("服务结束");
    }
}
