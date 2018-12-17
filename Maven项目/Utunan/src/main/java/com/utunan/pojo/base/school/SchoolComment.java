package com.utunan.pojo.base.school;

import com.utunan.pojo.base.user.User;

public class SchoolComment {
    //学校评论表Id
    private Long schoolcommentId;
    //方向Id
    private Long directionId;
    //评论者Id
    private Long userId;
    //评论内容
    private String schoolcommentcontent;

    //与方向表一对一
    private Direction direction;

    //与用户表一对一
    private User user;

    public Long getSchoolcommentId() {
        return schoolcommentId;
    }

    public void setSchoolcommentId(Long schoolcommentId) {
        this.schoolcommentId = schoolcommentId;
    }

    public Long getDirectionId() {
        return directionId;
    }

    public void setDirectionId(Long directionId) {
        this.directionId = directionId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getSchoolcommentcontent() {
        return schoolcommentcontent;
    }

    public void setSchoolcommentcontent(String schoolcommentcontent) {
        this.schoolcommentcontent = schoolcommentcontent;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "SchoolComment{" +
                "schoolcommentId=" + schoolcommentId +
                ", directionId=" + directionId +
                ", userId=" + userId +
                ", schoolcommentcontent='" + schoolcommentcontent + '\'' +
                ", direction=" + direction +
                ", user=" + user +
                '}';
    }
}
