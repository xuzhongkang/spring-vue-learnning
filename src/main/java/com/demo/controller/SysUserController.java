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
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.List;

/**
 * 用户controller层
 * .@Validated 代表该类启用参数验证，通过添加注解可以验证参数
 *
 * @author xuzhongknag on 2019/12/07.
 */

@Api(tags = "用户信息controller")
@RestController
@RequestMapping("/api")
@Validated
public class SysUserController {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SysUserService userService;
    @Autowired
    private ResultGenerator generator;

    @ApiOperation(httpMethod = "POST", value = "注册用户接口")
    @ApiImplicitParam(name = "SysUser", value = "用户对象", required = true, dataType = "Object")
    @RequestMapping("/register")
    public RestResult register(@Valid SysUser user, BindingResult bindingResult) {
        return generator.getSuccessResult("用户注册成功", userService.saveUser(user));
    }

    @ApiOperation(httpMethod = "POST", value = "用户登录接口")
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

    @ApiOperation(httpMethod = "POST", value = "新增用户")
    @ApiImplicitParam(name = "SysUser", value = "用户对象，包含姓名邮箱信息", required = true, dataType = "Object")
    @PostMapping(value = "/addUser")
    public RestResult addUser(@Valid SysUser user){
        userService.saveUser(user);
        return  generator.getSuccessResult("添加成功",user);
    }

    @ApiOperation(httpMethod = "DELETE", value = "根据工号删除用户")
    @ApiImplicitParam(name = "userId", value = "工号", required = true, dataType = "String")
    @DeleteMapping(value = "/delUser")
    public RestResult delUser(int no){
        userService.delUserByNo(no);
        return  generator.getSuccessResult("删除成功",null);
    }

    @ApiOperation(httpMethod = "GET", value = "根据编号查询用户信息")
    @ApiImplicitParam(name = "userNo", value = "用户编号", required = true, dataType = "int")
    @RequestMapping(value = "/getOneUser")
    public RestResult getOneUser(int userNo){
        SysUser sysUser = userService.getUserByNo(userNo);
        return  generator.getSuccessResult("查询结果",sysUser);
    }

    @ApiOperation(httpMethod = "GET", value = "查询全部用户信息")
    @RequestMapping(value = "/getUser")
    public RestResult getAllUser(){
        List allUser = userService.getAllUser();
        return  generator.getSuccessResult("查询结果",allUser);
    }

    @ApiOperation(httpMethod = "POST", value = "修改用户信息")
    @ApiImplicitParam(name = "user", value = "用户对象", required = true, dataType = "Object")
    @RequestMapping(value = "/updateUser")
    public RestResult updateUser(SysUser user){
        userService.updateUser(user);
        return  generator.getSuccessResult("修改成功", null);
    }

    /**
     * 异常处理器
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public RestResult handleConstraintViolationException(ConstraintViolationException cve) {
        String errorMessage = cve.getConstraintViolations().iterator().next().getMessage();
        System.out.println(errorMessage);
        return generator.getFailResult(errorMessage);
    }

}
