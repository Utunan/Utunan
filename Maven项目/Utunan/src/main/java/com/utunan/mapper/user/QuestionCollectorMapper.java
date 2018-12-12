package com.utunan.mapper.user;

import com.utunan.pojo.base.community.Quiz;
import com.utunan.pojo.base.questionbank.Question;
import com.utunan.pojo.base.questionbank.Subject;
import com.utunan.pojo.base.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface QuestionCollectorMapper {
    List<Question> selectQuestionCollector(User user);
    Subject selectSubject(Subject subject);
    int deleteQuestionCollector(@Param("userId")Long userId,@Param("questionId") String questionId);
}
