package com.utunan.pojo.inherit.school;

import com.utunan.pojo.base.school.Direction;
import com.utunan.pojo.base.school.School;
import com.utunan.pojo.base.user.User;

import java.util.List;

/**
 * @author 王碧云
 * @description: 研究方向继承学校类
 * @date 2018/11/29/029 18:47
 */
public class PublishDirection extends School {
    //与研究方向一对多
    private List<Direction> direction;

    @Override
    public List<Direction> getDirection() {
        return direction;
    }

    @Override
    public void setDirection(List<Direction> direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "PublishDirection{" +
                "direction=" + direction +
                '}';
    }
}
