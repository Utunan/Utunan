package com.utunan.pojo.community;

import com.utunan.pojo.user.User;

import java.util.Date;
import java.util.List;

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
    //悬赏金额
    private Long rewardAmount;
    //与用户多对一
    private User user;
    //与评论一对多
    private List<Comment> comment;

    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

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

    public Long getRewardAmount() {
        return rewardAmount;
    }

    public void setRewardAmount(Long rewardAmount) {
        this.rewardAmount = rewardAmount;
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
                ", rewardAmount"+rewardAmount+
                '}';
    }
}
