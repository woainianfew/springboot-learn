package com.huyang.service.impl;

import com.huyang.mapper.UserMapper;
import com.huyang.model.User;
import com.huyang.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * UserService实现
 *
 * @author huyang
 * @since 1.0
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User findByAccount(String account) {
        return userMapper.findByAccount(account);
    }
}
    