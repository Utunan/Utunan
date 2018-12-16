package com.utunan.service.community;

import com.utunan.pojo.base.community.Quiz;
import com.utunan.pojo.base.community.Tag;
import com.utunan.pojo.base.user.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuizService {
	/**
	 * @author  孙程程
	 * @description 查询问答列表
	 * @date  10:49 2018/12/13
	 * @param  orderBy, pageNum, pageSize
	 * @return  java.util.List<com.utunan.pojo.base.community.Quiz>
	 */
	List<Quiz> listQuiz(String orderBy, int pageNum, int pageSize);

	/**
	 * @author  孙程程
	 * @description 查询某标签下问答列表
	 * @date  10:49 2018/12/13
	 * @param  orderBy, pageNum, pageSize
	 * @return  java.util.List<com.utunan.pojo.base.community.Quiz>
	 */
	List<Quiz> listQuizByTag(String orderBy, String tagName, int pageNum, int pageSize);
	
	/**
	 * @author  张正扬
	 * @description 向quiz表存入问题
	 * @date  19:58 2018/11/21
	 * @param  title,content
	 * @return  null
	 */
	
	void saveQuiz(Long qid,User user,String title,String content);
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
	 * @return  com.utunan.pojo.base.community.Quiz
	 */
	Quiz findQuizById(Long quizId);
	
	/**
	 * @author  王碧云
	 * @description 根据quizId查评论数量
	 * @date  14:58 2018/11/25/025
	 * @param  quizId
	 * @return  java.lang.Long
	 */
	Long countAnswerByQuizId(Long quizId);
	
	/**
	 * @author  孙程程
	 * @description 根据quizId查标签列表
	 * @date  16:19 2018/11/28
	 * @param  quizId
	 * @return  java.util.List<com.utunan.pojo.base.community.Tag>
	 */
	List<Tag> selectTagByQuizId(Long quizId);

	 /** @author  唐溪
	 * @description
	 * @date   18:56 2018/11/25
	 * @param  quizList
	 * @return  void
	 */
	void condenseQuiz(List<Quiz> quizList);

	/*
	 * @author  张正扬
	 * @description 更新点赞计数
	 * @date  21:39 2018/11/27
	 * @param  [quizId]
	 * @return  void
	 */
	void praiseQuiz(Long quizId);
	
	/**
	 * @author  孙程程
	 * @description 通过quizId查找用户
	 * @date  20:15 2018/11/28
	 * @param  quizId
	 * @return  com.utunan.pojo.base.user.User

​	 */
	User findUserByQuizId(Long quizId);

	/*
	 * @author  张正扬
	 * @description 取出最大quizId
	 * @date  17:48 2018/11/28
	 * @param  null
	 * @return   Long

	 */
     Long getMaxQid();

     /*
      * @author  张正扬
      * @description 增加问题回答数
      * @date  20:51 2018/11/29
      * @param  null
      * @return  null
      */
     void addAnswerCount(Long qid);

     //删除点赞数量
    void delPraiseQuiz(Long quizId);

    //获取前10个评论数最高的问题
    List<Quiz> quizListTop10();

    //获取点赞数
	Long getCountPrise(Long quizId);
}
