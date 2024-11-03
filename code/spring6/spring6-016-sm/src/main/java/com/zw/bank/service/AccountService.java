package com.zw.bank.service;

import com.zw.bank.pojo.Account;

import java.util.List;

public interface AccountService {
    int save(Account account);
    int deleteByActno(String actno);
    int modify(Account account);
    Account getByActno(String actno);
    List<Account> getAll();
    void transfer(String fromActno, String toActno, double money);
}
