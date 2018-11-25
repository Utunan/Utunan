package com.utunan.service.community.impl;

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

    @Override
    public void saveComment(String content){
        Comment comment=new Comment();
        int k=253;
        long f=(long)k;

        comment.setCommentContent(content);
        comment.setCommentTime(new Date());
        int i=0;
        long j=(long) i;
        comment.setCommentPraiseCount(j);
        commentMapper.toInsert(comment);
    }

    /*
     * @author  张正扬
     * @description 从comment表取出刚刚插入的回答
     * @date  15:47 2018/11/22
     * @param  null
     * @return  Comment对象
     */

    @Override
    public Comment getComment(){
        return commentMapper.getComment();
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
}
