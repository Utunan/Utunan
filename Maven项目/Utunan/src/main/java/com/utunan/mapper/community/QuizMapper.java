package com.utunan.mapper.community;

import com.utunan.pojo.base.community.Quiz;
import com.utunan.pojo.base.community.Tag;
import com.utunan.pojo.base.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface QuizMapper {
	List<Quiz> listQuiz(@Param("orderBy") String orderBy);
	List<Quiz> listQuizByTag(@Param("quizId") List<Long> quizId, @Param("orderBy") String orderBy);

    User findUserByQuizId(@Param("quizId") Long quizId);
	Long countAnswerByQuizId(@Param("quizId") Long quizId);
	List<Tag> selectTagByQuizId(@Param("quizId") Long quizId);
    void toInsert(Quiz quiz);
   Quiz getQuiz1();
     /*王碧云 通过quizId查找问题*/
    Quiz findQuizById(@Param("quizId") Long quizId);

	List<Long> selectQuizIdByTagName(@Param("tagName") String tagName);

	
	/*
	 * @author  张正扬
	 * @description 点赞更新
	 * @date  21:36 2018/11/27
	 * @param  quizId
	 * @return  void
	 */
	void updatePraiseCount(@Param("quizId") Long quizId);
	List<Quiz> selectQuizByUserId(User user);



	/*
	 * @author  张正扬
	 * @description 获取最大quizId
	 * */
	Long getMax();


	/*
	 * @author  张正扬
	 * @description 增加问题回答数
	 * @date  20:54 2018/11/29
	 * @param
	 * @return
	 */
	void addAnswerCount(@Param("quizId") Long quizId);

	//删除点赞数
    void delPraiseQuiz(@Param("quizId") Long quizId);

    //查询评论数前10的问题
    List<Quiz> quizListTop10();
}
