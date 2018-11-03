package com.utunan.pojo;

public class UserQuestionBank {
    //用户所有答题情况列表
    private Long userQuestionBankId;
    //用户Id
    private Long userId;
    //问题Id
    private Long questionId;
    //答案Id
    private String userQuestionBankAnswer;
    //用户答案
    private Integer userQuestionBankResult;

    public Long getUserQuestionBankId() {
        return userQuestionBankId;
    }

    public void setUserQuestionBankId(Long userQuestionBankId) {
        this.userQuestionBankId = userQuestionBankId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getUserQuestionBankAnswer() {
        return userQuestionBankAnswer;
    }

    public void setUserQuestionBankAnswer(String userQuestionBankAnswer) {
        this.userQuestionBankAnswer = userQuestionBankAnswer;
    }

    public Integer getUserQuestionBankResult() {
        return userQuestionBankResult;
    }

    public void setUserQuestionBankResult(Integer userQuestionBankResult) {
        this.userQuestionBankResult = userQuestionBankResult;
    }

    @Override
    public String toString() {
        return "UserQuestionBank{" +
                "userQuestionBankId=" + userQuestionBankId +
                ", userId=" + userId +
                ", questionId=" + questionId +
                ", userQuestionBankAnswer='" + userQuestionBankAnswer + '\'' +
                ", userQuestionBankResult=" + userQuestionBankResult +
                '}';
    }
}
