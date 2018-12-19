package com.utunan.service.user.impl;

import com.github.pagehelper.PageHelper;
import com.utunan.mapper.user.QuestionCollectorMapper;
import com.utunan.pojo.base.questionbank.Question;
import com.utunan.pojo.base.user.User;
import com.utunan.service.user.QuestionCollectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("questionCollectorService")
public class QuestionCollectorServiceImpl implements QuestionCollectorService {

    @Autowired
    private QuestionCollectorMapper questionCollectorMapper;

    @Override
    public List<Question> getQuestionCollector(User user, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Question> questions=questionCollectorMapper.selectQuestionCollector(user);
        for(Question question:questions){
            question.setSubject(questionCollectorMapper.selectSubject(question.getSubject()));
        }
        return  questions;
    }
}
