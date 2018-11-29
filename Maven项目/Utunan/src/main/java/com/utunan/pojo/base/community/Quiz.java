package com.utunan.pojo.base.community;

import com.utunan.pojo.base.user.User;

import java.util.Date;
import java.util.List;

/**
 * Quiz:文章/帖子
 */
public class Quiz {
    //文章Id
    private Long quizId;
    //作者/用户Id
    private User user;
    //文章主题
    private String quizTitle;
    //文章内容
    private String quizContent;
    //发表时间
    private Date releaseTime;
    //点赞计数
    private Long praiseCount;
    //评论数量
    private Long commentCount;
    //标签
    private List<Tag> tags;

    public Long getQuizId() {
        return quizId;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

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

    public Long getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Long commentCount) {
        this.commentCount = commentCount;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "quizId=" + quizId +
                ", user=" + user +
                ", quizTitle='" + quizTitle + '\'' +
                ", quizContent='" + quizContent + '\'' +
                ", releaseTime=" + releaseTime +
                ", praiseCount=" + praiseCount +
                ", commentCount=" + commentCount +
                ", tags=" + tags +
                '}';
    }
}
