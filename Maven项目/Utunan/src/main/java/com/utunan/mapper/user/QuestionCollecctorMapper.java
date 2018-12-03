package com.utunan.mapper.user;

import com.utunan.pojo.base.community.Quiz;
import com.utunan.pojo.base.questionbank.Question;
import com.utunan.pojo.base.questionbank.Subject;
import com.utunan.pojo.base.user.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuestionCollecctorMapper {
    List<Question> selectQuestionCollector(User user);
    Subject selectSubject(Subject subject);
}
