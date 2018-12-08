package com.utunan.mapper.community;

import com.utunan.pojo.base.community.QuizGreat;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author 张正扬
 * @description: TODO
 * @date 2018/12/8 14:07
 */
@Mapper
@Repository
public interface QuizGreatMapper {
    //查询QuizGreat表信息
    QuizGreat getQuizGreat(@Param("quizId") Long quizId, @Param("userId") Long userId);

    //插入QuizGreat表信息
    void addQuizGreat(@Param("quizId") Long quizId, @Param("userId") Long userId);

    //删除QuizGreat表信息
    void delQuizGreat(@Param("quizId") Long quizId, @Param("userId") Long userId);
}
