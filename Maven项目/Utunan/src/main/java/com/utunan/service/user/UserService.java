package com.utunan.service.user;

import com.utunan.pojo.base.user.Member;
import com.utunan.pojo.base.user.Message;
import com.utunan.pojo.base.user.User;

import java.util.List;

public interface UserService {
    User getUser(User user);
    Member getUserById(String userId);
    Integer getUserMessageCount(User user);
    void saveUser(User user);
    void cancelFollow(Long followedUserId,Long followUserId);
    boolean isExist(User user);
    boolean changeInfo(User user);
    User changeUserPassword(User user);
    Message getMessage(String messageId);
    List<Message> getUserReadInfo(User user,int pageNum,int pageSize);
    List<Message> getUserNoReadInfo(User user,int pageNum,int pageSize);
    Integer isFollow(Long followedUserId,Long followUserId);
    boolean changeUserHeadImg(User user,String img);
    boolean changeUserTelephone(User user);
    boolean changeUserEmail(User user);
    boolean changeMessageIsView(String messageId);
    List<User> getAllUser(int pageNum,int pageSize);
    List<User> getAllMember(int pageNum,int pageSize);
    List<User> getAllAdmin(int pageNum,int pageSize);
    List<User> getFollowByUser(User user,int pageNum, int pageSize);
}
