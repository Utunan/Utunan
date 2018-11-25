package com.utunan.pojo.community;

import com.utunan.pojo.user.User;

import java.util.Date;

/**
 * 评论表-Comment
 */
public class Comment {
	//评论ID
	private Long commentId;
	//提问ID
	private Long quizId;
	//作者Id
	private Long userId;
	//评论内容
	private String commentContent;
	//评论时间
	private Date commentTime;
	//点赞个数
	private  Long commentPraiseCount;
	//父级评论Id
	private Long replyCommentId;
	//提问
	private Quiz quiz;
	//用户
	private User user;

	public User getUser() { return user; }

	public void setUser(User user) { this.user = user; }

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
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

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public Date getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}

	public Long getCommentPraiseCount() { return commentPraiseCount; 	}

	public void setCommentPraiseCount(Long commentPraiseCount) { this.commentPraiseCount = commentPraiseCount; }

	public Long getReplyCommentId() {
		return replyCommentId;
	}

	public void setReplyCommentId(Long replyCommentId) {
		this.replyCommentId = replyCommentId;
	}

	@Override
	public String toString() {
		return "Comment{" +
				"commentId=" + commentId +
				", quizId=" + quizId +
				", userId=" + userId +
				", commentContent='" + commentContent + '\'' +
				", commentTime=" + commentTime +
				", commentPraiseCount=" + commentPraiseCount +
				", replyCommentId=" + replyCommentId +
				'}';
	}
}
