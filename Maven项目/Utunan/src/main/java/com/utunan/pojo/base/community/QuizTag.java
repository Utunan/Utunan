package com.utunan.pojo.base.community;

/**
 * 提问标签-QuizTag
 */
public class QuizTag {
	//提问标签列表ID
	private Long quizTagId;
	//提问ID
	private Quiz quiz;
	//标签
	private Tag tag;

	public Long getQuizTagId() {
		return quizTagId;
	}

	public void setQuizTagId(Long quizTagId) {
		this.quizTagId = quizTagId;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

	@Override
	public String toString() {
		return "QuizTag{" +
				"quizTagId=" + quizTagId +
				", quiz=" + quiz +
				", tag=" + tag +
				'}';
	}
}
