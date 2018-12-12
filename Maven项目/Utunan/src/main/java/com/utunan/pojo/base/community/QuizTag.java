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


	private Long quizId;


	private Long tagId;




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

    public Long getQuizTagId() {
        return quizTagId;
    }

    public void setQuizTagId(Long quizTagId) {
        this.quizTagId = quizTagId;
    }


	public Long getQuizId() {
		return quizId;
	}

	public void setQuizId(Long quizId) {
		this.quizId = quizId;
	}

	public Long getTagId() {
		return tagId;
	}

	public void setTagId(Long tagId) {
		this.tagId = tagId;
	}

	@Override
	public String toString() {
		return "QuizTag{" +
				"quizTagId=" + quizTagId +
				", quiz=" + quiz +
				", tag=" + tag +
				", quizId=" + quizId +
				", tagId=" + tagId +
				'}';
	}
}
