package com.utunan.pojo.inherit.user;

import com.utunan.pojo.base.school.Direction;
import com.utunan.pojo.base.user.DirectionCollector;
import com.utunan.pojo.base.user.User;

/**
 * @author 王碧云
 * @description: 继承院校收藏
 * @date 2018/12/3/003 9:29
 */
public class PublishDirectionCollector extends DirectionCollector {

    private User user;

    private Direction direction;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "PublishDirectionCollector{" +
                "user=" + user +
                ", direction=" + direction +
                '}';
    }
}
