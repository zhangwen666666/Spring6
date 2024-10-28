package com.zw.spring6.service;

import com.zw.spring6.dao.UserDao;
import com.zw.spring6.dao.VipDao;

public class UserService {

    private UserDao userDao;
    private VipDao vipDao;

    // set注入的话，必须提供一个set方法，Spring容器会调用这个set方法，来给UserDao属性赋值
    // 可以自己写一个set方法，不符合javabean规范的
    // 至少这个方法是以set单词开始的，前三个字母不能随便写，必须是"set"
    public void setXxx(UserDao xyz){
        this.userDao = xyz;
    }

    public void setVipDao(VipDao vipDao) {
        this.vipDao = vipDao;
    }

    public void saveUser(){
        userDao.insert();
        vipDao.insert();
    }
}
