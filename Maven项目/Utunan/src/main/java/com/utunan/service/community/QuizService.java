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
	 * @param  [pageNum,pageSize]
	 * @return  java.util.List<com.utunan.pojo.community.Quiz>
	 */
	List<Quiz> getQuizByTime(int pageNum, int pageSize);

	/**
	 * @author  孙程程
	 * @description 根据点赞数量分页查询问答列表
	 * @date  17:15 2018/11/20
	 * @param  [pageNum, pageSize]
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
	/*
	 * @author  张正扬 
	 * @description 向Quiz表中存入问答信息
	 * @date  13:24 2018/11/21 
	 * @param  title,content
	 * @return  void
	 */
	void saveQuiz(String title,String content);
	/*
	 * @author  张正扬
	 * @description 根据 title,content返回一个Quiz对象
	 * @date  14:27 2018/11/21
	 * @param  title,content
	 * @return  Quiz
	 */

	Quiz getQuiz(String title,String content);
	
}
