package com.utunan.service.community;

import com.utunan.pojo.community.Comment;

import java.util.List;


public interface CommentService {

    /*
     * @author  张正扬
     * @description  向comment表中插入回答
     * @date  7:56 2018/11/22
     * @param content
     * @return   null
     */

    void saveComment(String content);
    /*
     * @author  张正扬
     * @description 从comment表中取出刚刚插入的回答，每次只取一条
     * @date  8:08 2018/11/22
     * @param  null
     * @return  Comment对象
     */

    Comment getComment();

    /*
     * @author  王碧云
     * @description 根据quizId返回评论列表
     * @date  15:31 2018/11/25/025
     * @param  []
     * @return  java.util.List<com.utunan.pojo.community.Comment>
     */
    List<Comment> findCommentListByQuizId(Long quizId);
}
