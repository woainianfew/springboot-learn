/**
 * Copyright (C) 2017 The BEST Authors
 */
package com.huyang.service;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 权限Service
 *
 * @author huayng
 * @since 1.0
 */
public interface PermissionService {

    /**
     *
     * 功能描述: 根据角色id查询权限
     * @param: roleIds
     * @return: List<String>
     * @auther: huyang
     * @date: 2020/10/16 15:01
     */
    List<String> findByRoleIds(@Param("roleIds") List<Integer> roleIds);
}

