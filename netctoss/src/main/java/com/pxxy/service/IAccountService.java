package com.pxxy.service;

import com.pxxy.domain.Account;
import com.pxxy.domain.PageBean;

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
    /**
     * 查询账户总记录数
     */
    int selectCount();
    /**
     * 根据页码查询记录数
     */
    PageBean<Account> findByPage(int currentPage);
}
