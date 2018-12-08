package com.utunan.mapper.community;

import com.utunan.pojo.base.user.QuizCollector;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author 张正扬
 * @description: TODO
 * @date 2018/12/6 16:07
 */

@Mapper
@Repository
public interface QuizCollectMapper {

    void insertQuizCollector(QuizCollector quizCollector);

    Long getMaxQCid();

    //获取QuizCollector表信息
    QuizCollector getQuizCollector(@Param("quizId") Long quizId, @Param("userId") Long userId);

    //删除用户收藏
    void delQuizCollector(@Param("quizId") Long quizId, @Param("userId") Long userId);
}
