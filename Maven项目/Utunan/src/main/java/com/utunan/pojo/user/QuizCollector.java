package com.utunan.pojo.user;

import com.utunan.pojo.community.Quiz;

/**
 * 帖子收藏列表-QuizCollector
 */
public class QuizCollector {
	//帖子收藏列表ID
	private Long quizCollectorId;
	//用户Id
	private User user;
	//提问ID
	private Quiz quiz;

	public Long getQuizCollectorId() {
		return quizCollectorId;
	}

	public void setQuizCollectorId(Long quizCollectorId) {
		this.quizCollectorId = quizCollectorId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	@Override
	public String toString() {
		return "QuizCollector{" +
				"quizCollectorId=" + quizCollectorId +
				", user=" + user +
				", quiz=" + quiz +
				'}';
	}
}
