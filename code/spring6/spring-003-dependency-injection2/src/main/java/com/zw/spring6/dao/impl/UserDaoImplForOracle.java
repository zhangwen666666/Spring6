package com.zw.spring6.dao.impl;

import com.zw.spring6.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDaoImplForOracle implements UserDao {
    private final static Logger logger = LoggerFactory.getLogger(UserDaoImplForOracle.class);
    @Override
    public int save() {
        logger.info("Oracle数据库正在保存User信息");
        return 0;
    }
}
