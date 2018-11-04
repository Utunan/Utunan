package com.utunan.mapper;

import com.utunan.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int insert(User user);
    User queryByTelephone(String userTelephone);
    User queryByEmail(String userEmail);



}
