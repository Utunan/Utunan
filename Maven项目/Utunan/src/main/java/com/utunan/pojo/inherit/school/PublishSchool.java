package com.utunan.pojo.inherit.school;

import com.utunan.pojo.base.school.Direction;
import com.utunan.pojo.base.school.School;
import com.utunan.pojo.base.user.User;
import com.utunan.pojo.inherit.user.PublishDirectionCollector;

import java.util.List;

/**
 * @author 王碧云
 * @description: 继承学校类
 * @date 2018/11/29/029 18:47
 */
public class PublishSchool extends School {
    //与研究方向一对多
    private List<Direction> direction;
    /*//与院校收藏一对多
    private List<PublishDirectionCollector> publishDirectionCollectors;111*/

    @Override
    public String toString() {
        return "PublishSchool{" +
                "direction=" + direction +
                '}';
    }
/*
    public List<PublishDirectionCollector> getPublishDirectionCollectors() {
        return publishDirectionCollectors;
    }

    public void setPublishDirectionCollectors(List<PublishDirectionCollector> publishDirectionCollectors) {
        this.publishDirectionCollectors = publishDirectionCollectors;
    }*/

    @Override
    public List<Direction> getDirection() {
        return direction;
    }

    @Override
    public void setDirection(List<Direction> direction) {
        this.direction = direction;
    }

}
