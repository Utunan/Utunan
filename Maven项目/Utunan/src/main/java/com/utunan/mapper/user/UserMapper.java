package com.utunan.mapper.user;

import com.utunan.pojo.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    int insert(User user);
    User queryByPermit(User user);
    User findByPermit(User user);
}

