package com.pxxy.service;

import com.pxxy.domain.Account;

import java.util.List;

/**
 * 账户的业务层接口
 */
public interface IAccountService {
    /**
     * 查询所有
     */
    List<Account> findAll();

    /**
     * 保存账户
     */
    int saveAccount(Account account);
    /**
     * 更新账户
     */
    int updateAccount(Account account);
}
