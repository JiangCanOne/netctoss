package com.pxxy.mapper;

import com.pxxy.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Descricption:账户的持久层接口
 * @Author:江灿
 * @Date:Create in 11:19 2019/5/29
 */
@Repository()
public interface AccountMapper {
    /**
     * 查询所有
     */
//    @Select("select * from account")
    List<Account> findAll();

    /**
     * 保存账户
     */
    @Insert("insert into account(name,money) values (#{name},#{money})")
    int saveAccount(Account account);
    /**
     * 更新账户
     */
    int updateAccount(Account account);
}