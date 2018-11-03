package com.utunan.pojo;

public class UserTempPractice {
    //用户本次练习情况列表
    private Long userTempPractice;
    //用户ID
    private Long userId;
    //答题数量
    private Long questionNum;
    //正确题目数量
    private Long correctNum;

    public Long getUserTempPractice() {
        return userTempPractice;
    }

    public void setUserTempPractice(Long userTempPractice) {
        this.userTempPractice = userTempPractice;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getQuestionNum() {
        return questionNum;
    }

    public void setQuestionNum(Long questionNum) {
        this.questionNum = questionNum;
    }

    public Long getCorrectNum() {
        return correctNum;
    }

    public void setCorrectNum(Long correctNum) {
        this.correctNum = correctNum;
    }

    @Override
    public String toString() {
        return "UserTempPractice{" +
                "userTempPractice=" + userTempPractice +
                ", userId=" + userId +
                ", questionNum=" + questionNum +
                ", correctNum=" + correctNum +
                '}';
    }

}
