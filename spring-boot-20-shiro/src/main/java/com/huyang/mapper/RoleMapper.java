/**
 * Copyright (C) 2017 The BEST Authors
 */
package com.huyang.mapper;

import com.huyang.model.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author huayng
 * @since
 */
public interface RoleMapper {

    /**
     *
     * 功能描述: 根据userId查询角色信息
     * @param: userId
     * @return: List<Role>
     * @auther: huyang
     * @date: 2020/10/16 14:57
     */
    List<Role> findRoleByUserId(@Param("userId") Integer userId);
}

