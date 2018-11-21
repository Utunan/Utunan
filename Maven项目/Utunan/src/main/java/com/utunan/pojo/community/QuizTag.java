package com.utunan.pojo.community;

/**
 * 提问标签-QuizTag
 */
public class QuizTag {
	//提问标签列表ID
	private Long quizTagId;
	//提问ID
	private Long quizId;
	//标签ID
	private Long tagId;
	//标签
	private Tag tag;

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

	public Long getQuizTagId() { return quizTagId; }

	public void setQuizTagId(Long quizTagId) {	this.quizTagId = quizTagId; }

	public Long getQuizId() { return quizId; }

	public void setQuizId(Long quizId) { this.quizId = quizId; }

	public Long getTagId() { return tagId; }

	public void setTagId(Long tagId) {	this.tagId = tagId; }

	@Override
	public String toString() {
		return "QuizTag{" +
				"quizTagId=" + quizTagId +
				", quizId=" + quizId +
				", tagId=" + tagId +
				'}';
	}
}
