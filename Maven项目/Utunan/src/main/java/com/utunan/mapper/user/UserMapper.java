package com.utunan.mapper.user;

import com.utunan.pojo.user.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    int insert(User user);
    User queryByTelephone(String userTelephone);
    User queryByEmail(String userEmail);



}
