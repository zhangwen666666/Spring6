package com.zw.spring6.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderDao {
    private static final Logger logger = LoggerFactory.getLogger(OrderDao.class);

    public void generate(){
        logger.info("订单正在生成");
    }
}
