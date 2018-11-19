package com.utunan.pojo.community;

import java.util.Date;

/**
 * Quiz:文章/帖子
 */
public class Quiz {
    //文章Id
    private Long quizId;
    //作者/用户Id
    private Long userId;
    //文章主题
    private String quizTitle;
    //文章内容
    private String quizContent;
    //发表时间
    private Date releaseTime;
    //点赞计数
    private Long praiseCount;

    public Long getQuizId() {
        return quizId;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }

    public Long getUserId() { return userId; }

    public void setUserId(Long userId) { this.userId = userId; }

    public String getQuizTitle() {
        return quizTitle;
    }

    public void setQuizTitle(String quizTitle) {
        this.quizTitle = quizTitle;
    }


    public String getQuizContent() {
        return quizContent;
    }

    public void setQuizContent(String quizContent) {
        this.quizContent = quizContent;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Long getPraiseCount() {
        return praiseCount;
    }

    public void setPraiseCount(Long praiseCount) {
        this.praiseCount = praiseCount;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "quizId=" + quizId +
                ", userId=" + userId +
                ", quizTitle='" + quizTitle + '\'' +
                ", quizContent='" + quizContent + '\'' +
                ", releaseTime=" + releaseTime +
                ", praiseCount=" + praiseCount +
                '}';
    }
}
