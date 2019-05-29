package com.pxxy.service.impl;

import com.pxxy.mapper.AdministorMapper;
import com.pxxy.service.IAdministorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Descricption:业务层管理员接口实现类
 * @Author:江灿
 * @Date:Create in 11:05 2019/5/29
 */
@Service("administorService")
public class AdministorService implements IAdministorService {
    @Autowired
    private AdministorMapper administorMapper;
}
