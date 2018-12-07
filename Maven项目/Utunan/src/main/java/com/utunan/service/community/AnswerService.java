package com.utunan.service.community;

import com.utunan.pojo.base.community.Answer;
import com.utunan.pojo.base.community.Quiz;
import com.utunan.pojo.base.user.User;

import java.util.List;


public interface AnswerService {

    /*
     * @author  张正扬
     * @description  向comment表中插入回答
     * @date  7:56 2018/11/22
     * @param content
     * @return   null
     */
    
    void saveAnswer(Long aid, Quiz quiz, String content, User user);
    /*
     * @author  张正扬
     * @description  向comment表中插入评论
     * @date  7:56 2018/11/22
     * @param content，commentId，uid
     * @return   null
     */
    
    void saveAnswer1(Long aid,Long answerId,String content,User user);
    
    /*
     * @author  王碧云
     * @description 根据quizId返回评论列表
     * @date  15:31 2018/11/25/025
     * @param  []
     * @return  java.util.List<com.utunan.pojo.base.community.Answer>
     */
    List<Answer> findAnswerListByQuizId(int pageNum,int pageSize,Long quizId);
    
    /*
     * @author  王碧云
     * @description 根据commentId返回子评论列表
     * @date  21:11 2018/11/25/025
     * @param  [commentId]
     * @return  java.util.List<com.utunan.pojo.base.community.Answer>
     */
    List<Answer> findChildAnswerListByAnswerId(Long answerId);
    
    /*
     * @author  王碧云
     * @description 根据热度返回评论列表
     * @date  11:14 2018/11/26/026
     * @param  [quizId]
     * @return  java.util.List<com.utunan.pojo.base.community.Answer>
     */
    List<Answer> findAnswerListByPraiseCount(int pageNum,int pageSize,Long quizId);
    
    /*
     * @author  王碧云
     * @description 根据quizId获取父级为null的评论数
     * @date  21:36 2018/11/26/026
     * @param  [quizId]
     * @return  java.lang.Long
     */
    //Long countAnswerByQuizId(Long quizId);
    
    /**
     * @author  孙程程
     * @description 根据搜索条件返回评论列表
     * @date  16:12 2018/11/27
     * @param  searchValue, pageNum, pageSize
     * @return  java.util.List<com.utunan.pojo.base.community.Answer>
     */
    List<Answer> findAnswerListBySearch(String searchValue, int pageNum, int pageSize);

    /*
     * @author  张正扬
     * @description 获取最大commentid
     * @date  19:25 2018/11/28
     * @param  null
     * @return  Long
     */
    Long getMaxAid();

    /*
     * @author  张正扬
     * @description 实现回答点赞功能
     * @date  22:35 2018/12/4
     * @param  Long
     * @return  void
     */
    void praiseAnswer(Long num);

    //根据answerId查询子评论数量按时间查询
    Long findchildAnswerCount(Long answerId);



    //根据answerId查询子评论数量按热度查询
    List<Answer> findChildAnswerListByCount(Long answerId);
}
