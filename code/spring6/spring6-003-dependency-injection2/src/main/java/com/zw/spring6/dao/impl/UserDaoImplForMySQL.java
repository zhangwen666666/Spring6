package com.zw.spring6.dao.impl;

import com.zw.spring6.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDaoImplForMySQL implements UserDao {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImplForMySQL.class);
    @Override
    public int save() {
        logger.info("MySql数据库正在保存User信息");
        return 0;
    }
}
