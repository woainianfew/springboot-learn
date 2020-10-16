/**
 * Copyright (C) 2017 The BEST Authors
 */
package com.huyang.common.realm;

import com.huyang.model.Role;
import com.huyang.model.User;
import com.huyang.service.PermissionService;
import com.huyang.service.RoleService;
import com.huyang.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 权限信息验证AuthRealm
 *
 * @author huyang
 * @since 1.0
 */
public class AuthRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;

    @Resource
    private PermissionService permissionService;

    /**
     * 功能描述: 授权
     * @param: principalCollection
     * @return: AuthorizationInfo
     * @auther: huyang
     * @date: 2020/10/16 15:48
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        User user = (User) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        //根据用户id查询角色信息
        List<Role> roleList = roleService.findRoleByUserId(user.getId());
        Set<String> roleSet = new HashSet<>();
        List<Integer> roleIds = new ArrayList<>();
        for(Role role : roleList){
            roleSet.add(role.getRole());
            roleIds.add(role.getId());
        }

        //放入角色信息
        authorizationInfo.setRoles(roleSet);

        //放入权限信息
        List<String> permissionList = permissionService.findByRoleIds(roleIds);
        authorizationInfo.setStringPermissions(new HashSet<>(permissionList));

        return authorizationInfo;
    }

    /**
     * 功能描述: 认证
     * @param: authenticationToken
     * @return: AuthenticationInfo
     * @auther: huyang
     * @date: 2020/10/16 15:48
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        //根据用户名查询用户信息
        User user = userService.findByAccount(token.getUsername());
        if(user == null){
            return null;
        }

        return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
    }
}
    