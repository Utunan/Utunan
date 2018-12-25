package com.utunan.mapper.community;

import com.utunan.pojo.base.community.Answer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 张正扬
 * @description: TODO
 * @date 2018/11/22 17:01
 */
@Mapper
@Repository
public interface AnswerMapper {
    void toInsert(Answer answer);


    /*根据quizId返回评论列表（王碧云）*/
    List<Answer> findAnswerListByQuizId(@Param("quizId") Long quizId);

    /*根据commentId返回子评论列表（王碧云）*/
    List<Answer> findChildAnswerListByAnswerId(@Param("answerId") Long answerId);

    /*王碧云 根据热度返回评论列表*/
    List<Answer> findAnswerListByPraiseCount(@Param("quizId") Long quizId);

    /*王碧云 根据quizId获取父级为null的评论数*/
    //Long countAnswerByQuizId(@Param("quizId") Long quizId);

    //向comment表中插入评论
    void toInsert1(Answer answer);

    //从comment表中取出最大commentId
    Long getMaxAid();


    /*
     * @author  张正扬
     * @description 更新回答点赞
     * @date  22:39 2018/12/4
     * @param Long
     * @return null
     */
    void updatePraiseCount(Long answerId);


    //根据answerId查询子评论数量
     Long findchildAnswerCount(Long answerId);

    //根据answerId查询子评论按热度查询
    List<Answer> findChildAnswerListByCount(Long answerId);

    //取消回答点赞
    void delPraiseAnswer(Long answerId);

    //查询刚插入的评论信息
    Answer getAnswer(@Param("answerId") Long answerId);

    //根据answerId删除回答及评论
    void delAnswer(@Param("answerId") Long answerId);

    //登录用户删除评论
    void delComment(@Param("answerId") Long answerId, @Param("parentanswerId") Long parentanswerId);
}
