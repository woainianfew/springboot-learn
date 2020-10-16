/**
 * Copyright (C) 2017 The BEST Authors
 */
package com.huyang.service.impl;

import com.huyang.mapper.PermissionMapper;
import com.huyang.service.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * PermissionService实现
 *
 * @author huyang
 * @since 1.0
 */
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {

    @Resource
    private PermissionMapper permissionMapper;

    @Override
    public List<String> findByRoleIds(List<Integer> roleIds) {
        return permissionMapper.findByRoleIds(roleIds);
    }
}
    