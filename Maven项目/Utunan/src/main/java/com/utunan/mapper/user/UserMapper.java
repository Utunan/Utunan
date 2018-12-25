package com.utunan.mapper.user;

import com.utunan.pojo.base.community.Quiz;
import com.utunan.pojo.base.questionbank.Question;
import com.utunan.pojo.base.user.Message;
import com.utunan.pojo.base.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    //插入用户
    int insert(User user);
    //通过
    List<User> selectAllUser();
    List<User> selectAllMember();
    List<User> selectAllAdmin();
    List<User> selectFollowUser(User user);
    User selectByUserId(@Param("userId")Long userId);
    User selectByPermit(User user);
    User selectByPorE(User user);
    User selectByP(User user);
    List<Message> selectUserAllReadInfo(User user);
    List<Message> selectUserAllNoReadInfo(User user);

    default int selectIsFollow(@Param("followedUserId") Long followedUserId, @Param("followUserId") Long followUserId) {
        return 0;
    }

    Message selectMessageById(String messageId);
    int selectUserMessage(User user);
    int updateUser(User user);
    int updateUserPassword(User user);
    int updateUserHeadImg(@Param("userId")Long userId, @Param("userHeadImg")String userHeadImg);
    int updateUserTelephone(User user);
    int updateUserEmail(User user);
    int updateMessage(@Param("messageId")Long messageId);
    void deleteFollow(@Param("followedUserId")Long followedUserId,@Param("followUserId")Long followUserId);

}

