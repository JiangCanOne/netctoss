package com.pxxy.service.impl;

import com.pxxy.domain.Administor;
import com.pxxy.mapper.AdministorMapper;
import com.pxxy.service.IAdministorService;
import com.pxxy.service.ex.AdministorServiceException;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.Md5Crypt;
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

    @Override
    public Administor login(Administor administor) {
        Administor administor1 = administorMapper.findByAdminNumber(administor.getAdminNumber());
        if(administor1 == null){
            throw new AdministorServiceException("该管理员不存在");
        }
        if(!(DigestUtils.md5Hex(administor.getPassword().getBytes())).equals(administor1.getPassword())){
            throw new AdministorServiceException("管理员账号或密码错误");
        }
        return administor1;
    }
}
