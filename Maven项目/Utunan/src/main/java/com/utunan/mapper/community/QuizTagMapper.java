package com.utunan.mapper.community;

import com.utunan.pojo.community.QuizTag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface QuizTagMapper {

    /*王碧云 通过quizId查找标签*/
    List<QuizTag> findQuizTagByQuizId(@Param("quizId") Long quizId);

}
