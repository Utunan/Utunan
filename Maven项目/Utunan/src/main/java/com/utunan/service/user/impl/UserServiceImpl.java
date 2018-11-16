package com.utunan.service.user.impl;

import com.utunan.mapper.user.UserMapper;
import com.utunan.pojo.user.User;
import com.utunan.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(User user) {
        User u=userMapper.queryByPermit(user);
        return u;
    }

    @Override
    public void saveUser(User user) {
        Date date = new Date();
        user.setRegisterTime(date);
        user.setLoginTime(date);
        userMapper.insert(user);
    }
    @Override
    public boolean isExist(User user) {
        User u=userMapper.findByPermit(user);
        if(u!=null)
            return true;
        return false;
    }
}
