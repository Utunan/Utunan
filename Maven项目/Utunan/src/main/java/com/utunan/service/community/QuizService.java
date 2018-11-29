package com.utunan.service.community;

import com.utunan.pojo.community.Quiz;
import com.utunan.pojo.util.BigQuiz;

import java.util.List;

public interface QuizService {
	/**
	 * @author  孙程程
	 * @description 根据发表时间分页查询问答列表
	 * @date  16:20 2018/11/19
	 * @param  pageNum
	 * @param  pageSize
	 * @return  java.util.List<com.utunan.pojo.community.Quiz>
	 */
	List<BigQuiz> quizListByTime(int pageNum, int pageSize);

	/**
	 * @author  孙程程
	 * @description 根据点赞数量分页查询问答列表
	 * @date  17:15 2018/11/20
	 * @param  pageNum
	 * @param  pageSize
	 * @return  java.util.List<com.utunan.pojo.community.Quiz>
	 */
	List<BigQuiz> quizListByPraise(int pageNum, int pageSize);

	/**
	 * @author  孙程程
	 * @description 所有问答数量
	 * @date  20:16 2018/11/19
	 * @return  java.lang.Long
	 */
	Long countAllQuiz();

	/**
	 * @author  张正扬
	 * @description 向quiz表存入问题
	 * @date  19:58 2018/11/21
	 * @param  title,content
	 * @return  null
	 */

	void saveQuiz(Long qid,Long uid,String title,String content);
	/**
	 * @author  张正扬
	 * @description
	 * @date  20:21 2018/11/21
	 * @param
	 * @return
	 */
	Quiz getQuiz();

	/**
	 * @author  王碧云
	 * @description 根据quizId查找Quiz
	 * @date  12:28 2018/11/24
	 * @param  quizId
	 * @return  com.utunan.pojo.community.Quiz
	 */
	Quiz findQuizById(Long quizId);

	/**
	 * @author  王碧云
	 * @description 根据quizId查评论数量
	 * @date  14:58 2018/11/25/025
	 * @param  quizId
	 * @return  java.lang.Long
	 */
	Long countCommentByQuizId(Long quizId);

	/**
  
	 * @author  孙程程
	 * @description 在某标签下根据发表时间分页查询问答列表
	 * @date  8:46 2018/11/26
	 * @param  tagName, pageNum, pageSize
	 * @return  java.util.List<com.utunan.pojo.util.BigQuiz>
	 */
	List<BigQuiz> quizListByTimeWithTagName(String tagName, int pageNum, int pageSize);

	/**
	 * @author  孙程程
	 * @description 在某标签下根据点赞数量分页查询问答列表
	 * @date  15:36 2018/11/26
	 * @param  tagName, pageNum, pageSize
	 * @return  java.util.List<com.utunan.pojo.util.BigQuiz>
	 */
	List<BigQuiz> quizListByPraiseWithTagName(String tagName, int pageNum, int pageSize);

	/**
	 * @author  孙程程
	 * @description 某标签下所有问答数量
	 * @date  8:56 2018/11/26
	 * @param  tagName
	 * @return  java.lang.Long
	 */
	Long countQuizWithTagName(String tagName);

	 /** @author  唐溪
	 * @description
	 * @date   18:56 2018/11/25
	 * @param  quizList
	 * @return  void
	 */
	void condenseQuiz(List<Quiz> quizList);

	/**
	 * @author  孙程程
	 * @description 根据搜索条件查找提问列表
	 * @date  20:12 2018/11/26
	 * @param  searchValue
	 * @return  java.util.List<com.utunan.pojo.community.Quiz>
	 */
	List<BigQuiz> findQuizBySearch(String searchValue, int pageNum, int pageSize);

	/**
	 * @author  孙程程
	 * @description 符合搜索条件的提问数量
	 * @date  21:19 2018/11/26
	 * @param  searchValue
	 * @return  java.lang.Long
	 */
	Long countQuizBySearch(String searchValue);
	/*
	 * @author  张正扬
	 * @description 更新点赞计数
	 * @date  21:39 2018/11/27
	 * @param  [quizId]
	 * @return  void
	 */
	void praiseQuiz(Long quizId);

	/*
	 * @author  张正扬
	 * @description 取出最大quizId
	 * @date  17:48 2018/11/28
	 * @param  null
	 * @return   Long
	 */
	Long getMaxQid();

}
