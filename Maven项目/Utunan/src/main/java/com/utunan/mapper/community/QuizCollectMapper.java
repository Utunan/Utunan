package com.utunan.mapper.community;

import com.utunan.pojo.base.user.QuizCollector;
import org.apache.ibatis.annotations.Mapper;
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
}
