package com.utunan.service.community;

import com.utunan.pojo.base.community.Answer;
import com.utunan.pojo.inherit.community.PublishQuiz;

import java.util.List;

/**
 * @author 张正扬
 * @description: TODO
 * @date 2018/12/3 17:05
 */
public interface PublishQuizService {
    /*
     * @author  王碧云
     * @description 根据quizId获取父级为null的评论数
     * @date  21:38 2018/11/26/026
     * @param  [quizId]
     * @return  java.lang.Long
     */
     Long countAnswerByQuizId(Long quizId);

     PublishQuiz findAnswerListByQuizId(Long quizId);

    /*
     * @author  王碧云
     * @description 根据热度返回评论列表
     * @date  11:15 2018/11/26/026
     * @param  [quizId]
     * @return  java.util.List<com.utunan.pojo.base.community.Answer>
     */
    PublishQuiz findAnswerListByPraiseCount(Long quizId);

    /**
     * @author  孙程程
     * @description 根据搜索条件返回评论列表
     * @date  16:12 2018/11/27
     * @param  searchValue, pageNum, pageSize
     * @return  java.util.List<com.utunan.pojo.base.community.Answer>
     */
    List<Answer> findAnswerListBySearch(String searchValue, int pageNum, int pageSize);
}
