package com.demo.service;

import com.demo.entity.SysUser;

import java.util.List;

/**
 * 用户服务层接口
 * @author xuzhongknag on 2019/12/07
 */
public interface SysUserService {
    /**
     * 注册用户
     * @param user
     * @return 注册成功将用户信息返回，否则返回null
     */
    SysUser saveUser(SysUser user);

    /**
     * 检查用户名密码是否正确
     * @param name 用户名
     * @param password 密码
     * @return 验证通过则将用户信息返回，否则返回null
     */
    SysUser checkLogin(String name,String password);

    /**
     * 获取全部用户信息
     * */
    List getAllUser();

    /**
     * 根据工号查询用户
     * */
    SysUser getUserByNo(int no);

    /**
     * 根据工号删除用户
     * */
    void delUserByNo(int no);

    /**
     * 更新用户信息
     * */
    void updateUser(SysUser user);
}
