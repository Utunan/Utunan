package com.utunan.pojo.base.questionbank;

import com.utunan.pojo.base.user.User;

import java.util.Date;

/**
 * @author 孙程程
 * @description: TODO
 * @date 2018/11/28 9:42
 */
public class DirectionComment {
	//研究方向评论表ID
	private Long directionCommentId;
	//用户ID
	private Long userId;
	//研究方向ID
	private Long directionId;
	//评论内容
	private String directionCommentContent;
	//评论时间
	private Date directionCommentTime;
	//评论点赞数量
	private Long directionCommentPraiseCount;
	//上级评论ID
	private Long replyDirectionCommentId;

	//与用户一对一
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getDirectionCommentId() {
		return directionCommentId;
	}

	public void setDirectionCommentId(Long directionCommentId) {
		this.directionCommentId = directionCommentId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getDirectionId() {
		return directionId;
	}

	public void setDirectionId(Long directionId) {
		this.directionId = directionId;
	}

	public String getDirectionCommentContent() {
		return directionCommentContent;
	}

	public void setDirectionCommentContent(String directionCommentContent) {
		this.directionCommentContent = directionCommentContent;
	}

	public Date getDirectionCommentTime() {
		return directionCommentTime;
	}

	public void setDirectionCommentTime(Date directionCommentTime) {
		this.directionCommentTime = directionCommentTime;
	}

	public Long getDirectionCommentPraiseCount() {
		return directionCommentPraiseCount;
	}

	public void setDirectionCommentPraiseCount(Long directionCommentPraiseCount) {
		this.directionCommentPraiseCount = directionCommentPraiseCount;
	}

	public Long getReplyDirectionCommentId() {
		return replyDirectionCommentId;
	}

	public void setReplyDirectionCommentId(Long replyDirectionCommentId) {
		this.replyDirectionCommentId = replyDirectionCommentId;
	}

	@Override
	public String toString() {
		return "DirectionComment{" +
				"directionCommentId=" + directionCommentId +
				", userId=" + userId +
				", directionId=" + directionId +
				", directionCommentContent='" + directionCommentContent + '\'' +
				", directionCommentTime=" + directionCommentTime +
				", directionCommentPraiseCount=" + directionCommentPraiseCount +
				", replyDirectionCommentId=" + replyDirectionCommentId +
				", user=" + user +
				'}';
	}
}
