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

    void saveComment(Long cid,Long quizId,String content,Long uid);
    /*
     * @author  张正扬
     * @description  向comment表中插入评论
     * @date  7:56 2018/11/22
     * @param content，commentId，uid
     * @return   null
     */

    void saveComment1(Long cid,Long commentId,String content,Long uid);

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

    /*
     * @author  王碧云
     * @description 根据quizId获取父级为null的评论数
     * @date  21:36 2018/11/26/026
     * @param  [quizId]
     * @return  java.lang.Long
     */
    Long countCommentByQuizId(Long quizId);

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

    /*
     * @author  张正扬
     * @description 获取最大commentid
     * @date  19:25 2018/11/28
     * @param  null
     * @return  Long
     */
    Long getMaxCid();
}
