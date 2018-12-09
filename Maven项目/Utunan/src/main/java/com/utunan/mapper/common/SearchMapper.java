package com.utunan.mapper.common;

import com.utunan.pojo.base.community.Answer;
import com.utunan.pojo.base.community.Quiz;
import com.utunan.pojo.base.school.Direction;
import com.utunan.pojo.base.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SearchMapper {
	List<User> findUser(@Param("keyWord") String keyWord);
	List<Quiz> findQuiz(@Param("keyWord") String keyWord);
	List<Answer> findAnswer(@Param("keyWord") String keyWord);
}
