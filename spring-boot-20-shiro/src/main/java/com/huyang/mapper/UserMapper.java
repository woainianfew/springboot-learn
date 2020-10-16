/**
 * Copyright (C) 2017 The BEST Authors
 */
package com.huyang.mapper;

import com.huyang.model.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author huyang
 * @since
 */
public interface UserMapper {

    /**
     *
     * 功能描述: 根据账户查询用户信息
     * @param: account
     * @return: User
     * @auther: huyang
     * @date: 2020/10/16 14:59
     */
    User findByAccount(@Param("account") String account);
}

