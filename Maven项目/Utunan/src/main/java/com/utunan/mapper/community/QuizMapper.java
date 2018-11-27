package com.utunan.mapper.community;

import com.utunan.pojo.community.Quiz;
import com.utunan.pojo.community.QuizTag;
import com.utunan.pojo.community.Tag;
import com.utunan.pojo.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface QuizMapper {
    List<Quiz> listQuizByTime(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);
    List<Quiz> listQuizByPraise(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);
    Long countAllQuiz();
    User findUserByQuizId(@Param("quizId") Long quizId);
	Long countCommentByQuizId(@Param("quizId") Long quizId);
	List<Tag> selectTagByQuizId(@Param("quizId") Long quizId);
    void toInsert(Quiz quiz);
    Quiz getQuiz1();
    /*王碧云 通过quizId查找问题*/
    Quiz findQuizById(@Param("quizId") Long quizId);

	List<Quiz> listQuizByTimeWithTagName(@Param("quizId") List<Long> quizId, @Param("pageNum") int pageNum, @Param("pageSize") int pageSize);
	List<Quiz> listQuizByPraiseWithTagName(@Param("quizId") List<Long> quizId,@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);
	Long countQuizWithTagName(@Param("tagName") String tagName);
	List<Long> selectQuizIdByTagName(@Param("tagName") String tagName);

	List<Quiz> findQuizBySearch(@Param("searchValue") String searchValue, @Param("pageNum") int pageNum, @Param("pageSize") int pageSize);
	Long countQuizBySearch(@Param("searchValue") String searchValue);

}
