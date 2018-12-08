package com.utunan.mapper.admin;

import com.utunan.pojo.base.community.Quiz;
import com.utunan.pojo.base.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper
public interface AdminQuizMapper {
    List<Quiz> selectAllQuiz();
}
