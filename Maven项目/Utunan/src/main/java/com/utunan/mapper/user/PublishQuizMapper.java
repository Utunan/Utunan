package com.utunan.mapper.user;

import com.utunan.pojo.base.community.Quiz;
import com.utunan.pojo.base.community.Tag;
import com.utunan.pojo.base.user.User;
import com.utunan.pojo.inherit.user.PublishQuiz;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PublishQuizMapper {
    List<Quiz> selectPublishQuiz(User user);
}
