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
}

