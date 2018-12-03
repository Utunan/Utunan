package com.utunan.service.user.impl;

import com.utunan.mapper.user.UserMapper;
import com.utunan.pojo.base.user.User;
import com.utunan.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(User user) {
        User u=userMapper.selectByPermit(user);
        return u;
    }

    @Override
    public void saveUser(User user) {
        Date date = new Date();
        user.setRegisterTime(date);
        userMapper.insert(user);
    }
    @Override
    public boolean isExist(User user) {
        User u=userMapper.selectByPorE(user);
        if(u!=null) {
	        return true;
        }
        return false;
    }

    @Override
    public boolean changeInfo(User user) {
        userMapper.updateUser(user);
        return true;
    }

    @Override
    public User changeUserPassword(User user) {
        userMapper.updateUserPassword(user);
        User updateUser =userMapper.selectByPermit(user);
        return updateUser;
    }

    @Override
    public boolean changeUserHeadImg(User user, String userHeadImg) {

        userMapper.updateUserHeadImg(user.getUserId(),userHeadImg);
        return true;
    }
}
