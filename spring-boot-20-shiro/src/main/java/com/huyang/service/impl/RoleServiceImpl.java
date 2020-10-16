/**
 * Copyright (C) 2017 The BEST Authors
 */
package com.huyang.service.impl;

import com.huyang.mapper.RoleMapper;
import com.huyang.model.Role;
import com.huyang.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * RoleService实现
 *
 * @author huyang
 * @since 1.0
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public List<Role> findRoleByUserId(Integer userId) {
        return roleMapper.findRoleByUserId(userId);
    }
}
    