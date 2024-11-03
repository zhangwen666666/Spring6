package com.zw.bank.dao;

import com.zw.bank.pojo.Account;

/**
 * 专门负责账户信息的CRUD操作
 * 只负责执行SQL语句，没有任何逻辑代码
 */
public interface AccountDao {
    /**
     * 根据账号查询账户信息
     * @param actno
     * @return
     */
    Account selectByActno(String actno);

    /**
     * 更新账户信息
     * @param account
     * @return
     */
    int update(Account account);
}
