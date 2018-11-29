package com.utunan.pojo.base.community;

import com.utunan.pojo.base.user.User;

import java.util.Date;

/**
 * 评论表-Comment
 */
public class Comment {
	//评论ID
	private Long commentId;
	//评论内容
	private String commentContent;
	//提问
	private Quiz quiz;
	//用户
	private User user;
	//评论时间
	private Date commentTime;
	//点赞个数
	private  Long commentPraiseCount;
	//父级评论
	private Comment parentComment;

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public Long getCommentPraiseCount() {
        return commentPraiseCount;
    }

    public void setCommentPraiseCount(Long commentPraiseCount) {
        this.commentPraiseCount = commentPraiseCount;
    }

    public Comment getParentComment() {
        return parentComment;
    }

    public void setParentComment(Comment parentComment) {
        this.parentComment = parentComment;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", commentContent='" + commentContent + '\'' +
                ", quiz=" + quiz +
                ", user=" + user +
                ", commentTime=" + commentTime +
                ", commentPraiseCount=" + commentPraiseCount +
                ", parentComment=" + parentComment +
                '}';
    }
}
