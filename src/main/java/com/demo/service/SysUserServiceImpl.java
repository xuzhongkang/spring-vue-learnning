package com.demo.service;

import com.demo.entity.SysUser;
import com.demo.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户服务层实现类
 * Created by xuzhongknag on 2019/12/07.
 */
@Service("SysUserService")
public class SysUserServiceImpl implements SysUserService{
    @Autowired
    SysUserRepository userRepository;

    @Override
    public SysUser saveUser(SysUser user) {
        return userRepository.save(user);
    }

    @Override
    public SysUser checkLogin(String name, String password) {
        return userRepository.findFirstByNameAndPassword(name, password);
    }
}
