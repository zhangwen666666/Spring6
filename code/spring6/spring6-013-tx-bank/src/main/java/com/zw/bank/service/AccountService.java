package com.zw.bank.service;

import com.zw.bank.exceptions.AccountNotExistException;
import com.zw.bank.exceptions.MoneyNotEnoughException;
import com.zw.bank.exceptions.TransferException;

/**
 * 业务接口
 * 事务就是在这个接口下控制的
 */
public interface AccountService {
    /**
     * 转账方法
     * @param fromActno
     * @param toActno
     * @param money
     */
    void transfer(String fromActno, String toActno,double money) throws AccountNotExistException, MoneyNotEnoughException, TransferException;
}
