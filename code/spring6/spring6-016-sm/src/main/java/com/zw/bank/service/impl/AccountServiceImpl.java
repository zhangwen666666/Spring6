package com.zw.bank.service.impl;

import com.zw.bank.pojo.Account;
import com.zw.bank.service.AccountService;

import java.util.List;

public class AccountServiceImpl implements AccountService {
    @Override
    public int save(Account account) {
        return 0;
    }

    @Override
    public int deleteByActno(String actno) {
        return 0;
    }

    @Override
    public int modify(Account account) {
        return 0;
    }

    @Override
    public Account getByActno(String actno) {
        return null;
    }

    @Override
    public List<Account> getAll() {
        return null;
    }

    @Override
    public void transfer(String fromActno, String toActno, double money) {

    }
}
