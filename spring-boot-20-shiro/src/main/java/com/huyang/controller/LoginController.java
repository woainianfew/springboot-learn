/**
 * Copyright (C) 2017 The BEST Authors
 */
package com.huyang.controller;

import com.huyang.common.dto.ResponseCode;
import com.huyang.common.enums.StatusEnums;
import com.huyang.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

/**
 * 登录
 *
 * @author huyang
 * @since 1.0
 */
@RestController
public class LoginController {

    /**
     * 功能描述: 登录操作
     * @param: user
     * @return:
     * @auther: huyang
     * @date: 2020/10/16 16:39
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseCode login(@RequestBody User user){

        Subject userSubject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getAccount(),user.getPassword());

        try{
            //登录验证
            userSubject.login(token);
            return ResponseCode.success();
        }catch(UnknownAccountException e){
            return ResponseCode.error(StatusEnums.ACCOUNT_UNKNOWN);
        }catch(DisabledAccountException e){
            return ResponseCode.error(StatusEnums.ACCOUNT_DISABLED);
        }catch(IncorrectCredentialsException e){
            return ResponseCode.error(StatusEnums.INCORRECT_CREDENTIALS);
        }catch(Throwable e){
            e.printStackTrace();
            return ResponseCode.error(StatusEnums.SYSTEM_ERROR);
        }
    }

    @GetMapping("/login")
    public ResponseCode login(){
        return ResponseCode.error(StatusEnums.NOT_LOGININ);
    }

    @GetMapping("/auth")
    public String auth(){
        return "已成功登录";
    }

    @GetMapping("/role")
    @RequiresRoles("vip")
    public String role(){
        return "测试vip角色";
    }

    @GetMapping("/permission")
    @RequiresPermissions(value={"add","update"}, logical = Logical.AND)
    public String permission(){
        return "测试Add和Update权限";
    }

    /**
     *
     * 功能描述: 登出
     * @param:
     * @return:
     * @auther: huyang
     * @date: 2020/10/16 17:17
     */
    @GetMapping("/logout")
    public ResponseCode logout(){
        SecurityUtils.getSubject().logout();
        return ResponseCode.success();
    }
}
    