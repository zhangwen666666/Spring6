package com.zw.bank.mapper;

import com.zw.bank.pojo.Account;

import java.util.List;

/**
 * 该接口的实现类不需要写，通过mybatis动态生成
 * 这就是DAO，只需要编写CRUD方法
 */
public interface AccountMapper {
    int insert(Account account);
    int deleteByActno(String actno);
    int update(Account account);
    Account selectByActno(String actno);
    List<Account> selectAll();
}
