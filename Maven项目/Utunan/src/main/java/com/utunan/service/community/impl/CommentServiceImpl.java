package com.utunan.service.community.impl;

import com.github.pagehelper.PageHelper;
import com.utunan.mapper.community.CommentMapper;
import com.utunan.pojo.community.Comment;
import com.utunan.service.community.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author 张正扬
 * @description: TODO
 * @date 2018/11/22 17:05
 */
@Service("commentService")
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    /*
     * @author  张正扬
     * @description 向comment表插入回答
     * @date  15:47 2018/11/22
     * @param  content
     * @return  null
     */

    /*
     * @author  张正扬
     * @description 向comment表插入回答
     * @date  15:47 2018/11/22
     * @param  content
     * @return  null
     */

    @Override
    public void saveComment(Long quizId,String content,Long uid){
        Comment comment=new Comment();
        comment.setQuizId(quizId);
        comment.setUserId(uid);
        comment.setCommentContent(content);
        comment.setCommentTime(new Date());
        int i=0;
        long j=(long) i;
        comment.setCommentPraiseCount(j);
        commentMapper.toInsert(comment);
    }
    /*
     * @author  王碧云
     * @description 根据quiaId返回评论列表
     * @date  15:35 2018/11/25/025
     * @param  []
     * @return  java.util.List<com.utunan.pojo.community.Comment>
     */
    @Override
    public List<Comment> findCommentListByQuizId(Long quizId) {
        return this.commentMapper.findCommentListByQuizId(quizId);
    }

    /*
     * @author  王碧云
     * @description 根据commentId返回子评论列表
     * @date  21:12 2018/11/25/025
     * @param  [commentId]
     * @return  java.util.List<com.utunan.pojo.community.Comment>
     */
    @Override
    public List<Comment> findChildCommentListByCommentId(Long commentId) {
        return this.commentMapper.findChildCommentListByCommentId(commentId);
    }

    /*
     * @author  王碧云
     * @description 根据热度返回评论列表
     * @date  11:15 2018/11/26/026
     * @param  [quizId]
     * @return  java.util.List<com.utunan.pojo.community.Comment>
     */
    @Override
    public List<Comment> findCommentListByPraiseCount(Long quizId) {
        return this.commentMapper.findCommentListByPraiseCount(quizId);
    }

    /*
     * @author  王碧云
     * @description 根据quizId获取父级为null的评论数
     * @date  21:38 2018/11/26/026
     * @param  [quizId]
     * @return  java.lang.Long
     */
    @Override
    public Long countCommentByQuizId(Long quizId) {
        return this.commentMapper.countCommentByQuizId(quizId);
    }

    /**
     * @author  孙程程
     * @description 根据搜索条件返回评论列表
     * @date  16:12 2018/11/27
     * @param  searchValue, pageNum, pageSize
     * @return  java.util.List<com.utunan.pojo.community.Comment>
     */
    @Override
    public List<Comment> findCommentListBySearch(String searchValue, int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Comment> commentList=this.commentMapper.findCommentListBySearch("%"+searchValue+"%");
        return commentList;
    }

    /**
     * @author  孙程程
     * @description 根据搜索条件返回评论数量
     * @date  16:13 2018/11/27
     * @param  searchValue
     * @return  java.lang.Long
     */
    @Override
    public Long countCommentBySearch(String searchValue){
        return this.commentMapper.countCommentBySearch("%"+searchValue+"%");
    }
    /*
     * @author  张正扬
     * @description 向comment表插入回答
     * @date  15:47 2018/11/22
     * @param  content
     * @return  null
     */

    @Override
    public void saveComment1(Long commentId,String content,Long uid){
        Comment comment=new Comment();
        comment.setReplyCommentId(commentId);
        comment.setUserId(uid);
        comment.setCommentContent(content);
        comment.setCommentTime(new Date());
        int i=0;
        long j=(long) i;
        comment.setCommentPraiseCount(j);
        commentMapper.toInsert1(comment);
    }
}
