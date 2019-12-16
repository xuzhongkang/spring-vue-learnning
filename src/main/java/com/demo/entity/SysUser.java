package com.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 用户表实体类
 * .@Size @NotNull 都是validation框架的注解
 * @author xuzhongknag on 2019/12/07.
 */
@Entity
public class SysUser {
    @Id
    @GeneratedValue
    private Integer id;

    @Size(min = 6 , max = 18, message = "用户名应设为6至18位")
    @Column(unique = true,nullable = false)
    private String name;

    @Column(nullable = false)
    @Size(min = 6 , max = 18, message = "密码应设为6至18位")
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
