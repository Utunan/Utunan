package com.utunan.service.user;

import com.utunan.pojo.user.User;

public interface UserService {
    User getUser(User user);
    void saveUser(User user);
    boolean isExist(User user);
}
