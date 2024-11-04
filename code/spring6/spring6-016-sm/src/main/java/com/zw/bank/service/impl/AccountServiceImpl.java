package com.zw.bank.service.impl;

import com.zw.bank.exceptions.AccountNotExistException;
import com.zw.bank.exceptions.MoneyNotEnoughException;
import com.zw.bank.exceptions.TransferException;
import com.zw.bank.mapper.AccountMapper;
import com.zw.bank.pojo.Account;
import com.zw.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public int save(Account account) {
        return accountMapper.insert(account);
    }

    @Override
    public int deleteByActno(String actno) {
        return accountMapper.deleteByActno(actno);
    }

    @Override
    public int modify(Account account) {
        return accountMapper.update(account);
    }

    @Override
    public Account getByActno(String actno) {
        return accountMapper.selectByActno(actno);
    }

    @Override
    public List<Account> getAll() {
        return accountMapper.selectAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void transfer(String fromActno, String toActno, double money) throws AccountNotExistException, MoneyNotEnoughException, TransferException {
        Account fromAct = accountMapper.selectByActno(fromActno);
        Account toAct = accountMapper.selectByActno(toActno);
        if (fromAct == null || toAct == null) {
            throw new AccountNotExistException("账户不存在");
        }
        if (fromAct.getBalance() < money) {
            throw new MoneyNotEnoughException("余额不足");
        }

        fromAct.setBalance(fromAct.getBalance() - money);
        toAct.setBalance(toAct.getBalance() + money);

        int count = accountMapper.update(fromAct);

        String s = null;
        s.toString();

        count += accountMapper.update(toAct);

        if(count != 2){
            throw new TransferException("转账异常，请重试");
        }
    }
}
