package com.zw.bank.service.impl;

import com.zw.bank.dao.AccountDao;
import com.zw.bank.exceptions.AccountNotExistException;
import com.zw.bank.exceptions.MoneyNotEnoughException;
import com.zw.bank.exceptions.TransferException;
import com.zw.bank.pojo.Account;
import com.zw.bank.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Resource(name = "accountDao")
    private AccountDao accountDao;

    @Override
    @Transactional
    public void transfer(String fromActno, String toActno, double money) throws AccountNotExistException, MoneyNotEnoughException, TransferException {

        // 第一步：开启事务

        // 第二步：执行核心业务逻辑
        Account fromAct = accountDao.selectByActno(fromActno);
        Account toAct = accountDao.selectByActno(toActno);
        if(fromAct == null){
            throw new AccountNotExistException("转出账户不存在");
        }
        if(toActno == null){
            throw new AccountNotExistException("转入账户不存在");
        }
        if(fromAct.getBalance() < money){
            throw new MoneyNotEnoughException("余额不足！");
        }

        // 余额充足
        // 修改内存中两个对象的余额
        fromAct.setBalance(fromAct.getBalance() - money);
        toAct.setBalance(toAct.getBalance() + money);

        // 更新数据库
        int count = accountDao.update(fromAct);

        // 模拟异常
        int i = 1/0;

        count += accountDao.update(toAct);

        if(count != 2){
            throw new TransferException("转账失败，原因未知，请重试");
        }

        // 第三步：执行业务流程中没有异常，提交事务
        // 第四步：执行业务流程中遇到异常，回滚事务
    }
}
