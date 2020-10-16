/**
 * Copyright (C) 2017 The BEST Authors
 */
package com.huyang.service;

import com.huyang.model.Role;

import java.util.List;

/**
 * 角色的Service接口
 *
 * @author huyang
 * @since 1.0
 */
public interface RoleService {
    
    /**
     *
     * 功能描述: 根据userId查询角色信息
     * @param: userId
     * @return: List<Role>
     * @auther: huyang
     * @date: 2020/10/16 14:57
     */
    List<Role> findRoleByUserId(Integer userId);
}

