package com.pxxy.mapper;

import com.pxxy.domain.Account;
import com.pxxy.domain.Administor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @Descricption:管理员的持久层接口
 * @Author:江灿
 * @Date:Create in 11:19 2019/5/29
 */
@Repository()
public interface AdministorMapper {
    /*
     * @Author:江灿
     * @Description:根据管理员登录账号查询
     * @Date: 17:16 2019/5/30
     * @Param: [adminNumber]
     * @return: com.pxxy.domain.Administor
     **/
    Administor findByAdminNumber(String adminNumber);
}
