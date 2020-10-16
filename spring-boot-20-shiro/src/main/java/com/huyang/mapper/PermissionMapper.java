/**
 * Copyright (C) 2017 The BEST Authors
 */
package com.huyang.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author huyang
 * @since
 */
public interface PermissionMapper {

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

