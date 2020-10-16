/**
 * Copyright (C) 2017 The BEST Authors
 */
package com.huyang.service;

import com.huyang.model.User;

/**
 * 用户的Service接口
 *
 * @author huyang
 * @since 1.0
 */
public interface UserService {

    /**
     *
     * 功能描述: 根据账户查询用户信息
     * @param: account
     * @return: User
     * @auther: huyang
     * @date: 2020/10/16 14:59
     */
    User findByAccount(String account);
}

