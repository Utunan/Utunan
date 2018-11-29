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
    //与用户多对一
    private User user;
    //标签
    private Tag tag;

    //与评论一对多
    private List<Comment> comment;
    //与quiz_tag一对多
    private List<QuizTag> quizTag;


    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public List<QuizTag> getQuizTag() {
        return quizTag;
    }

    public void setQuizTag(List<QuizTag> quizTag) {
        this.quizTag = quizTag;
    }

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
