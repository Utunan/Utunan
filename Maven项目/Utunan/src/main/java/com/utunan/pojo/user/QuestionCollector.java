package com.utunan.pojo.user;

/**
 * 题目收藏列表-QuestionCollector
 */
public class QuestionCollector {
	//题目收藏列表ID
	private Long questionCollector;
	//用户ID
	private Long userId;
	//题目ID
	private Long questionId;
	//笔记
	private String note;

	public Long getQuestionCollector() {
		return questionCollector;
	}

	public void setQuestionCollector(Long questionCollector) {
		this.questionCollector = questionCollector;
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

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "QuestionCollector{" +
				"questionCollector=" + questionCollector +
				", userId=" + userId +
				", questionId=" + questionId +
				", note='" + note + '\'' +
				'}';
	}
}
