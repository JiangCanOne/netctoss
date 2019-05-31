package com.pxxy.service;

import com.pxxy.domain.Administor;

/**
 * @Descricption:业务层管理员接口
 * @Author:江灿
 * @Date:Create in 11:04 2019/5/29
 */
public interface IAdministorService {
   /*
    * @Author:江灿
    * @Description:管理员登录
    * @Date: 17:22 2019/5/30
    * @Param: [administor]
    * @return: com.pxxy.domain.Administor
    **/
    Administor login(Administor administor);



}
