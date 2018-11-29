package com.utunan.service.user.impl;

import com.github.pagehelper.PageHelper;
import com.utunan.mapper.user.PublishQuizMapper;
import com.utunan.pojo.base.community.Quiz;
import com.utunan.pojo.base.user.User;
import com.utunan.pojo.inherit.user.PublishQuiz;
import com.utunan.service.user.PublishQuizService;
import com.utunan.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("publishQuizService")
public class PublishQuizServiceImpl implements PublishQuizService {

    @Autowired
    private PublishQuizMapper publishQuizMapper;

    @Override
    public List<PublishQuiz> getUserPublishQuiz(User user, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<PublishQuiz> publishQuizs = publishQuizMapper.selecAllQuizCollectorByUser(user);
        for (Quiz quiz : publishQuizs.get(0).getQuizzes()) {
            quiz.setQuizContent(StringUtil.delHTMLTag(quiz.getQuizContent()));
            if(quiz.getQuizTitle().length()>23)
//                System.out.println(666);
                quiz.setQuizTitle(quiz.getQuizTitle().substring(0,23));

        }
        return publishQuizs;
    }
}
