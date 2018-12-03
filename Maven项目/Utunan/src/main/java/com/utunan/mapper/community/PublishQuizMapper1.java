package com.utunan.mapper.community;

import com.utunan.pojo.base.community.Answer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 张正扬
 * @description: TODO
 * @date 2018/12/3 14:36
 */
@Mapper
@Repository
public interface PublishQuizMapper1 {
    /*王碧云 根据quizId获取父级为null的评论数*/
    Long countAnswerByQuizId(@Param("quizId") Long quizId);

    /*根据quizId返回评论列表（王碧云）*/
    List<Answer> findAnswerListByQuizId(@Param("quizId") Long quizId);

    /*王碧云 根据热度返回评论列表*/
    List<Answer> findAnswerListByPraiseCount(@Param("quizId") Long quizId);


    //根据搜索条件返回评论列表
    List<Answer> findAnswerListBySearch(@Param("searchValue") String searchValue);
}
