package com.pxxy.controller;

import com.pxxy.domain.Account;
import com.pxxy.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 账户的表现层
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    /**
     * 查询所有
     */
    @RequestMapping("/findAll")
    public String findAll(){
        List<Account> accounts = accountService.findAll();
        for (Account account : accounts){
            System.out.println(account);
        }
        return "list";
    }

}
