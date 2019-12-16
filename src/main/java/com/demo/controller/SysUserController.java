package com.demo.controller;

import com.demo.entity.RestResult;
import com.demo.entity.SysUser;
import com.demo.service.SysUserService;
import com.demo.utils.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 用户controller层
 * .@Validated 代表该类启用参数验证，通过添加注解可以验证参数
 *
 * @author xuzhongknag on 2019/12/07.
 */

@Api(tags = "用户信息controller")
@RestController
@RequestMapping("/user")
@Validated
public class SysUserController {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SysUserService userService;
    @Autowired
    private ResultGenerator generator;

    @ApiOperation(httpMethod = "GET", value = "注册用户接口")
    @ApiImplicitParam(name = "SysUser", value = "用户对象", required = true, dataType = "Object")
    @RequestMapping("/register")
    public RestResult register(@Valid SysUser user, BindingResult bindingResult) {
        return generator.getSuccessResult("用户注册成功", userService.saveUser(user));
    }


    @ApiOperation(httpMethod = "GET", value = "用户登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String")
    })
    @PostMapping(value = "/login")
    public RestResult login(String name, String password) {
        System.out.println("name:" + name + ";password:" + password);
        SysUser user = userService.checkLogin(name, password);
        if (user != null) {
            return generator.getSuccessResult("登陆成功", user);
        }
        return generator.getFailResult("用户名/密码错误");
    }

}
