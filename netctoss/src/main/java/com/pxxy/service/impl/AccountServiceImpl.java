package com.pxxy.service.impl;

import com.pxxy.domain.Account;
import com.pxxy.mapper.AccountMapper;
import com.pxxy.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 账户的业务层实现类
 */
@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public List<Account> findAll() {
        System.out.println("业务层findAll()方法执行了 。。。");
        return accountMapper.findAll();
    }

    @Override
    public int saveAccount(Account account) {
       int i =  accountMapper.saveAccount(account);
        return i;
    }

    @Override
    public int updateAccount(Account account) {
        return accountMapper.updateAccount(account);
    }
}
