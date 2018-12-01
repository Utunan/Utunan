package com.utunan.service.user.impl;

import com.github.pagehelper.PageHelper;
import com.utunan.mapper.user.QuizCollectorMapper;
import com.utunan.pojo.base.community.Quiz;
import com.utunan.pojo.base.user.User;
import com.utunan.service.user.QuizCollectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("quizCollectorService")
public class QuizCollectorServiceImpl implements QuizCollectorService {

    @Autowired
    private QuizCollectorMapper quizCollectorMapper;
    @Override
    public List<Quiz> getQuizCollector(User user,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Quiz> quizzes= quizCollectorMapper.selectQuizCollector(user);
        return  quizzes;
    }
}
