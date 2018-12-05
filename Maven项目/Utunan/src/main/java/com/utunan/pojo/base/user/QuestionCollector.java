package com.utunan.pojo.base.user;

import com.utunan.pojo.base.questionbank.Question;

/**
 * 题目收藏列表-QuestionCollector
 */
public class QuestionCollector {
	//题目收藏列表ID
	private Long questionCollector;
	//用户
	private User user;
	//题目
	private Question question;

	public Long getQuestionCollector() {
		return questionCollector;
	}

	public void setQuestionCollector(Long questionCollector) {
		this.questionCollector = questionCollector;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "QuestionCollector{" +
				"questionCollector=" + questionCollector +
				", user=" + user +
				", question=" + question +
				'}';
	}
}
