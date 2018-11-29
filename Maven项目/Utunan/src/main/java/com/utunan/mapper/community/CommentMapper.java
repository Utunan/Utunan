package com.utunan.mapper.community;

import com.utunan.pojo.community.Comment;
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
public interface CommentMapper {
    void toInsert(Comment comment);
    Comment getComment();

    /*根据quizId返回评论列表（王碧云）*/
    List<Comment> findCommentListByQuizId(@Param("quizId") Long quizId);

    /*根据commentId返回子评论列表（王碧云）*/
    List<Comment> findChildCommentListByCommentId(@Param("commentId") Long commentId);

    /*王碧云 根据热度返回评论列表*/
    List<Comment> findCommentListByPraiseCount(@Param("quizId") Long quizId);

    /*王碧云 根据quizId获取父级为null的评论数*/
    Long countCommentByQuizId(@Param("quizId") Long quizId);

    //根据搜索条件返回评论列表
    List<Comment> findCommentListBySearch(@Param("searchValue") String searchValue);

    //根据搜索条件返回评论数量
    Long countCommentBySearch(@Param("searchValue") String searchValue);


    //向comment表中插入评论
    void toInsert1(Comment comment);

    //从comment表中取出最大commentId
    Long getMaxCid();
}

