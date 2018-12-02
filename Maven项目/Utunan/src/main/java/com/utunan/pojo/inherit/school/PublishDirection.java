package com.utunan.pojo.inherit.school;

import com.utunan.pojo.base.questionbank.DirectionComment;
import com.utunan.pojo.base.school.Direction;
import com.utunan.pojo.base.school.School;
import com.utunan.pojo.inherit.questionbank.PublishDirectionComment;

import java.util.List;

/**
 * @author 王碧云
 * @description: 继承研究方向类
 * @date 2018/11/29/029 18:47
 */
public class PublishDirection extends Direction {
    //与学校一对一
    private School school;
    //与研究方向的评论一对多
    private List<DirectionComment> directionComments;

    public List<DirectionComment> getDirectionComments() {
        return directionComments;
    }

    public void setDirectionComments(List<DirectionComment> directionComments) {
        this.directionComments = directionComments;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "PublishDirection{" +
                "school=" + school +
                ", directionComments=" + directionComments +
                '}';
    }
}
