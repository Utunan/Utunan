package com.utunan.pojo.user;

/**
 * 帖子收藏列表-QuizCollector
 */
public class QuizCollector {
	//帖子收藏列表ID
	private Long quizCollectorId;
	//用户Id
	private Long userId;
	//提问ID
	private Long quizId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getQuizCollectorId() {
		return quizCollectorId;
	}

	public void setQuizCollectorId(Long quizCollectorId) {
		this.quizCollectorId = quizCollectorId;
	}

	public Long getQuizId() {
		return quizId;
	}

	public void setQuizId(Long quizId) {
		this.quizId = quizId;
	}

	@Override
	public String toString() {
		return "QuizCollector{" +
				"postCollectorId=" + quizCollectorId +
				", postId=" + quizId +
				'}';
	}
}
