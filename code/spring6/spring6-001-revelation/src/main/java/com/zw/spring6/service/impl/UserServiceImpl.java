package com.zw.spring6.service.impl;

import com.zw.spring6.dao.UserDao;
import com.zw.spring6.dao.impl.UserDaoImplForMySQL;
import com.zw.spring6.dao.impl.UserDaoImplForOracle;
import com.zw.spring6.service.UserService;

public class UserServiceImpl implements UserService {
    // private UserDao userDao = new UserDaoImplForMySQL();
    // private UserDao userDao = new UserDaoImplForOracle();
    private UserDao userDao;

    @Override
    public void deleteUser() {
        userDao.deleteById();
        System.out.println("处理其他业务代码");
    }
}
