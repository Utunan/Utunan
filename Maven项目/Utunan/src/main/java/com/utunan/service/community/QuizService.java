package com.utunan.service.community;

import com.utunan.pojo.community.Quiz;

import java.util.List;

/**
 * @author  孙程程
 * @description 问答
 * @date  16:21 2018/11/19
 */
public interface QuizService {
	/**
	 * @author  孙程程
	 * @description 根据发表时间分页查询问答列表
	 * @date  16:20 2018/11/19
	 * @param  pageNum
	 * @param  pageSize
	 * @return  java.util.List<com.utunan.pojo.community.Quiz>
	 */
	List<Quiz> getQuizByTime(int pageNum, int pageSize);

	/**
	 * @author  孙程程
	 * @description 根据点赞数量分页查询问答列表
	 * @date  17:15 2018/11/20
	 * @param  pageNum
	 * @param  pageSize
	 * @return  java.util.List<com.utunan.pojo.community.Quiz>
	 */
	List<Quiz> getQuizByPraise(int pageNum, int pageSize);

	/**
	 * @author  孙程程
	 * @description 所有问答数量
	 * @date  20:16 2018/11/19
	 * @return  java.lang.Long
	 */
	Long countAllQuiz();

	List<Long> countComment(int pageNum, int pageSize);

	/*
	 * @author  王碧云
	 * @description 根据quizId查找Quiz
	 * @date  12:28 2018/11/24
	 * @param  [quizId]
	 * @return  com.utunan.pojo.community.Quiz
	 */
	Quiz findQuizById(int quizId);
}
