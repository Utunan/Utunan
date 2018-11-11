package com.utunan.service.user.impl;

import com.utunan.mapper.user.UserMapper;
import com.utunan.pojo.user.User;
import com.utunan.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(User user) {
        User u=userMapper.queryByPermit(user);
        return u;
    }

    public void saveUser(User user){

    }
}
