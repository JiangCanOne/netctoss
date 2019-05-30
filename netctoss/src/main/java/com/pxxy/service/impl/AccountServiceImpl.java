package com.pxxy.service.impl;

import com.pxxy.domain.Account;
import com.pxxy.domain.PageBean;
import com.pxxy.mapper.AccountMapper;
import com.pxxy.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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

    @Override
    public int selectCount() {
        return accountMapper.selectCount();
    }

    @Override
    public PageBean<Account> findByPage(int currentPage) {
        HashMap<String,Object> map = new HashMap<String,Object>();
        PageBean<Account> pageBean = new PageBean<Account>();
        //封装当前页数
        pageBean.setCurrPage(currentPage);
        //每页显示的数据
        int pageSize=10;
        pageBean.setPageSize(pageSize);
        //封装总记录数
        int totalCount = accountMapper.selectCount();
        pageBean.setTotalCount(totalCount);
        //封装总页数
        double tc = totalCount;
        Double num =Math.ceil(tc/pageSize);//向上取整
        pageBean.setTotalPage(num.intValue());
        map.put("start",(currentPage-1)*pageSize);
        map.put("size", pageBean.getPageSize());
        //封装每页显示的数据
        List<Account> lists = accountMapper.findByPage(map);
        pageBean.setLists(lists);
        return pageBean;
    }
}
