package com.utunan.mapper.user;

import com.utunan.pojo.base.community.Answer;
import com.utunan.pojo.base.community.Quiz;
import com.utunan.pojo.base.community.Tag;
import com.utunan.pojo.base.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PublishAnswerMapper {
    List<Answer> selectPublishAnswer(User user);
    Quiz selectQuizByQuizId(Quiz quiz);
}
