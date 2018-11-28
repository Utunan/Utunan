package com.utunan.mapper.user;

import com.utunan.pojo.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Dictionary;
import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    int insert(User user);
    User selectByPermit(User user);
    User selectByUorE(User user);
    List<Dictionary> updateUser(User user);
}

