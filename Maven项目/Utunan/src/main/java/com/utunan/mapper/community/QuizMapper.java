package com.utunan.mapper.community;

import com.utunan.pojo.community.Quiz;
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
	Long countCommentByQuizId(@Param("quizId") Long quizId);
	List<Tag> selectTagByQuizId(@Param("quizId") Long quizId);
    void toInsert(Quiz quiz);
    Quiz getQuiz1();

    /*王碧云 通过quizId查找问题*/
    Quiz findQuizById(@Param("quizId") Long quizId);
}
