package com.utunan.service.user;

import com.utunan.pojo.base.user.Member;
import com.utunan.pojo.base.user.User;

import java.util.List;

public interface UserService {
    User getUser(User user);
    Member getUserById(String userId);
    Integer getUserMessageCount(User user);
    void saveUser(User user);
    boolean isExist(User user);
    boolean changeInfo(User user);
    User changeUserPassword(User user);
    boolean changeUserHeadImg(User user,String img);
    boolean changeUserTelephone(User user);
    boolean changeUserEmail(User user);
    List<User> getAllUser(int pageNum,int pageSize);
    List<User> getAllMember(int pageNum,int pageSize);
    List<User> getAllAdmin(int pageNum,int pageSize);
}
