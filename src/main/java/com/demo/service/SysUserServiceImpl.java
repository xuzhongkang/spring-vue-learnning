package com.demo.service;

import com.demo.entity.SysUser;
import com.demo.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户服务层实现类
 * @author  xuzhongknag on 2019/12/07.
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

    @Override
    public List getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public SysUser getUserByNo(int no) {
        return userRepository.getOne(no);
    }

    @Override
    public void delUserByNo(int no) {
        userRepository.delete(no);
    }

    @Override
    public void updateUser(SysUser user) {
        userRepository.saveAndFlush(user);
    }
}
