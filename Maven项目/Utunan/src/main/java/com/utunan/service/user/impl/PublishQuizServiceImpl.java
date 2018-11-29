package com.utunan.service.user.impl;

import com.github.pagehelper.PageHelper;
import com.utunan.mapper.community.QuizMapper;
import com.utunan.pojo.community.Quiz;
import com.utunan.pojo.user.User;
import com.utunan.service.user.PublishQuizService;
import com.utunan.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("publishQuizService")
public class PublishQuizServiceImpl implements PublishQuizService {

    @Autowired
    private QuizMapper quizMapper;

    @Override
    public List<Quiz> getUserPublishQuiz(User user, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Quiz> list=quizMapper.selectQuizByUserId(user);
        if(list!=null)
            for (Quiz quiz : list) {
                if(quiz.getQuizTitle().length()>20)
                    quiz.setQuizTitle(quiz.getQuizTitle().substring(0,18)+"...");
                quiz.setQuizContent(StringUtil.delHTMLTag(quiz.getQuizContent()));
            }
        return list;
    }
}
