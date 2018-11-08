package com.utunan.pojo.community;

import java.util.Date;

/**
 * 评论表-Comment
 */
public class Comment {
	//评论ID
	private Long commentId;
	//帖子ID
	private Long articleId;
	//作者Id
	private Long authorId;
	//评论内容
	private String commentContent;
	//评论时间
	private Date commentTime;
	//父级评论Id
	private Long replyCommentId;

	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public Long getArticleId() {
		return articleId;
	}

	public void setArticleId(Long articleId) {
		this.articleId = articleId;
	}

	public Long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
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
				", articleId=" + articleId +
				", authorId=" + authorId +
				", commentContent='" + commentContent + '\'' +
				", commentTime=" + commentTime +
				", replyCommentId=" + replyCommentId +
				'}';
	}
}
