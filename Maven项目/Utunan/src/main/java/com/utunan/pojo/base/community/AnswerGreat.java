package com.utunan.pojo.base.community;

/**
 * @author 张正扬
 * @description: TODO
 * @date 2018/12/8 17:02
 */
public class AnswerGreat {
    //主键Id
    private Long answerGreatId;
    //回答评论ID
    private Long answerId;
    //点赞用户ID
    private Long userId;

    public Long getAnswerGreatId() {
        return answerGreatId;
    }

    public void setAnswerGreatId(Long answerGreatId) {
        this.answerGreatId = answerGreatId;
    }

    public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "AnswerGreat{" +
                "answerGreatId=" + answerGreatId +
                ", answerId=" + answerId +
                ", userId=" + userId +
                '}';
    }
}
