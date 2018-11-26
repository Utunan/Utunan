package com.utunan.mapper.user;

import com.utunan.pojo.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    int insert(User user);
    User selectByPermit(User user);
    User selectByUorE(User user);
    void updateUser(User user);
}

