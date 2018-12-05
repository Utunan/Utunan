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
    public List<Quiz> getUserPublishQuiz(User user, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Quiz> quizzes = publishQuizMapper.selectPublishQuiz(user);
        for (Quiz quiz : quizzes) {
            quiz.setQuizContent(StringUtil.delHTMLTag(quiz.getQuizContent()));
            if(quiz.getQuizTitle().length()>23)
                quiz.setQuizTitle(quiz.getQuizTitle().substring(0,23));
            quiz.setTags(publishQuizMapper.selectQuizTag(quiz));

        }
        return quizzes;
    }
}
