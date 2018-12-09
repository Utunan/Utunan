package com.utunan.pojo.base.community;

/**
 * @author 张正扬
 * @description: TODO
 * @date 2018/12/8 14:01
 */
public class QuizGreat {
    //问题ID
    private Long quizId;
    //点赞用户ID
    private Long userId;

    public Long getQuizId() {
        return quizId;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "QuizGreat{" +
                "quizId=" + quizId +
                ", userId=" + userId +
                '}';
    }
}
