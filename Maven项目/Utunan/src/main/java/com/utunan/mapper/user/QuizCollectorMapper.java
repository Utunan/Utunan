package com.utunan.mapper.user;

import com.utunan.pojo.base.community.Quiz;
import com.utunan.pojo.base.user.QuizCollector;
import com.utunan.pojo.base.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface QuizCollectorMapper {
    List<Quiz> selectQuizCollector(User user);
    int deleteQuizCollector(@Param("userId")Long userId,@Param("quizId") String quizId);
}
