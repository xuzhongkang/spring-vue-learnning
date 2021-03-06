package com.demo.repository;

import com.demo.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户Dao层
 * 继承JapRepository，可以实现一些默认方法，如save/findAll/findOne/delete/count/exists 等
 * @author xuzhongknag on 2019/12/07.
 */
public interface SysUserRepository extends JpaRepository<SysUser,Integer> {
    /**
     * 按用户名——密码查找
     * @param name 用户名
     * @param password 密码
     */
    SysUser findFirstByNameAndPassword(String name, String password);

}
