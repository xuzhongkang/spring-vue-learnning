package com.demo.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * 用户表实体类
 * .@Size @NotNull 都是validation的注解
 *
 * @author xuzhongknag on 2019/12/07.
 */
@Entity
public class SysUser {


    @Size(min = 4, max = 18, message = "用户名应设为4至18位")
    @Column(unique = true, nullable = false)
    private String name;

    private String password;

    @Id
    private Integer no;

    private String email;

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
