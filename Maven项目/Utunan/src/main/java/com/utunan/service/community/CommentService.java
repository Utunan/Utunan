package com.utunan.service.community;

import com.utunan.pojo.community.Comment;
import org.apache.ibatis.annotations.Param;

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

    /*
     * @author  王碧云
     * @description 根据commentId返回子评论列表
     * @date  21:11 2018/11/25/025
     * @param  [commentId]
     * @return  java.util.List<com.utunan.pojo.community.Comment>
     */
    List<Comment> findChildCommentListByCommentId(Long commentId);

    /*
     * @author  王碧云
     * @description 根据热度返回评论列表
     * @date  11:14 2018/11/26/026
     * @param  [quizId]
     * @return  java.util.List<com.utunan.pojo.community.Comment>
     */
    List<Comment> findCommentListByPraiseCount(Long quizId);

    /**
     * @author  孙程程
     * @description 根据搜索条件返回评论列表
     * @date  16:12 2018/11/27
     * @param  searchValue, pageNum, pageSize
     * @return  java.util.List<com.utunan.pojo.community.Comment>
     */
    List<Comment> findCommentListBySearch(String searchValue, int pageNum, int pageSize);

    /**
     * @author  孙程程
     * @description 根据搜索条件返回评论数量
     * @date  16:13 2018/11/27
     * @param  searchValue
     * @return  java.lang.Long
     */
	Long countCommentBySearch(String searchValue);


}
