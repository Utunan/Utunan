package com.utunan.service.community.impl;

import com.github.pagehelper.PageHelper;
import com.utunan.mapper.community.PublishQuizMapper1;
import com.utunan.pojo.base.community.Answer;
import com.utunan.pojo.inherit.community.PublishQuiz;
import com.utunan.service.community.PublishQuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 张正扬
 * @description: TODO
 * @date 2018/12/3 17:06
 */
@Service("PublishQuizService")
public class PublishQuizServiceImpl implements PublishQuizService {

    @Autowired
    private PublishQuizMapper1 publishQuizMapper1;
    /*
     * @author  王碧云
     * @description 根据quizId获取父级为null的评论数
     * @date  21:38 2018/11/26/026
     * @param  [quizId]
     * @return  java.lang.Long
     */
    @Override
    public Long countAnswerByQuizId(Long quizId) {

        return this.publishQuizMapper1.countAnswerByQuizId(quizId);
    }

    @Override
    public PublishQuiz findAnswerListByQuizId(int pageNum,int pageSize,Long quizId) {
        PageHelper.startPage(pageNum,pageSize);
        return this.publishQuizMapper1.findAnswerListByQuizId(quizId);
    }


    /*
     * @author  王碧云
     * @description 根据热度返回评论列表
     * @date  11:15 2018/11/26/026
     * @param  [quizId]
     * @return  java.util.List<com.utunan.pojo.base.community.Answer>
     */
    @Override
    public PublishQuiz findAnswerListByPraiseCount(Long quizId) {
        return this.publishQuizMapper1.findAnswerListByPraiseCount(quizId);
    }



    /**
     * @author  孙程程
     * @description 根据搜索条件返回评论列表
     * @date  16:12 2018/11/27
     * @param  searchValue, pageNum, pageSize
     * @return  java.util.List<com.utunan.pojo.base.community.Answer>
     */
    @Override
    public List<Answer> findAnswerListBySearch(String searchValue, int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Answer> answerList =this.publishQuizMapper1.findAnswerListBySearch("%"+searchValue+"%");
        return answerList;
    }
}
