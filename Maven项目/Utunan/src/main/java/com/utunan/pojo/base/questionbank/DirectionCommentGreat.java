package com.utunan.pojo.base.questionbank;

/**
 * @author 王碧云
 * @description: 院校详情评论点赞
 * @date 2018/12/19/019 9:16
 */
public class DirectionCommentGreat {

    private Long directionCommentGreatId;
    //院校详情评论Id
    private Long directionCommentId;
    //点赞用户Id
    private Long userId;

    public Long getDirectionCommentGreatId() {
        return directionCommentGreatId;
    }

    public void setDirectionCommentGreatId(Long directionCommentGreatId) {
        this.directionCommentGreatId = directionCommentGreatId;
    }

    public Long getDirectionCommentId() {
        return directionCommentId;
    }

    public void setDirectionCommentId(Long directionCommentId) {
        this.directionCommentId = directionCommentId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "DirectionCommentGreat{" +
                "directionCommentGreatId=" + directionCommentGreatId +
                ", directionCommentId=" + directionCommentId +
                ", userId=" + userId +
                '}';
    }
}
