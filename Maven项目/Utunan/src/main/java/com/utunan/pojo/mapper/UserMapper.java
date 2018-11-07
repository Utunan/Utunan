package com.utunan.mapper;

import com.utunan.pojo.uerinfo.User;

public interface UserMapper {
    int insert(User user);
    User queryByTelephone(String userTelephone);
    User queryByEmail(String userEmail);



}
