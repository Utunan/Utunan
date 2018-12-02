package com.utunan.pojo.inherit.questionbank;

import com.utunan.pojo.base.questionbank.DirectionComment;
import com.utunan.pojo.base.user.User;

/**
 * @author 王碧云
 * @description: TODO
 * @date 2018/12/2/002 15:25
 */
public class PublishDirectionComment extends DirectionComment {

    //与用户一对一
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "PublishDirectionComment{" +
                "user=" + user +
                '}';
    }
}
