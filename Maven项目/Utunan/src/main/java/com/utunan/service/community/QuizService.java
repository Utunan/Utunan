package com.utunan.service.community;

import com.utunan.pojo.community.Quiz;

import java.util.List;

/**
 * @author  孙程程
 * @description 问答
 * @date  16:21 2018/11/19
 */
public interface QuizService {
	List<Quiz> getQuizByTime(int pageNum, int pageSize);
	Long countAllQuiz();
}
