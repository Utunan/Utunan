package com.utunan.service.user.impl;

import com.github.pagehelper.PageHelper;
import com.utunan.mapper.user.QuestionCollecctorMapper;
import com.utunan.pojo.base.questionbank.Question;
import com.utunan.pojo.base.user.User;
import com.utunan.service.questionbank.QuestionService;
import com.utunan.service.user.QuestionCollectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("questionCollectorService")
public class QuestionCollectorServiceImpl implements QuestionCollectorService {

    @Autowired
    private QuestionCollecctorMapper questionCollecctorMapper;

    @Override
    public List<Question> getQuestionCollector(User user, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Question> questions=questionCollecctorMapper.selectQuestionCollector(user);
        for(Question question:questions){
            question.setSubject(questionCollecctorMapper.selectSubject(question.getSubject()));
        }
        return  questions;
    }
}
