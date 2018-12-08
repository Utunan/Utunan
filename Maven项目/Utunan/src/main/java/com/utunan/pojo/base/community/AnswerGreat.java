package com.utunan.pojo.base.community;

/**
 * @author 张正扬
 * @description: TODO
 * @date 2018/12/8 17:02
 */
public class AnswerGreat {
    //回答评论ID
    private Long answerId;
    //点赞用户ID
    private Long userId;

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
                "answerId=" + answerId +
                ", userId=" + userId +
                '}';
    }
}
