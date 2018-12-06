package com.utunan.service.user.impl;

import com.github.pagehelper.PageHelper;
import com.utunan.mapper.user.UserMapper;
import com.utunan.pojo.base.user.User;
import com.utunan.service.user.UserService;
import com.utunan.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(User user) {
        User u=null;
        if(StringUtil.isEmail(user.getUserEmail())) {
            u = userMapper.selectByPermit(user);
        }else{
            u=userMapper.selectByP(user);
        }
        return u;
    }

    @Override
    public void saveUser(User user) {
        Date date = new Date();
        int x=(int)(Math.random()*100);
        String userNickName="Utunan"+(int)((Math.random()*9+1)*100000)+date.getTime()%10000000;
        System.out.println(userNickName);
        user.setUserNickName(userNickName);
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

    @Override
    public boolean changeUserTelephone(User user) {
        userMapper.updateUserTelephone(user);
        return true;
    }

    @Override
    public boolean changeUserEmail(User user) {
        userMapper.updateUserEmail(user);
        return true;
    }

    @Override
    public List<User> getAllUser(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<User> users=userMapper.selectAllUser();
        return users;
    }
}
