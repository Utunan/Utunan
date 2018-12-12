package com.utunan.service.user.impl;

import com.github.pagehelper.PageHelper;
import com.utunan.mapper.user.PublishAnswerMapper;
import com.utunan.pojo.base.community.Answer;
import com.utunan.pojo.base.user.User;
import com.utunan.service.user.PublishAnswerService;
import com.utunan.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("publishAnswerService")
public class PublishAnswerServiceImlp implements PublishAnswerService {

    @Autowired
    private PublishAnswerMapper publishAnswerMapper;

    @Override
    public List<Answer> getPublishAnswer(User user, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Answer> answers=publishAnswerMapper.selectPublishAnswer(user);
        for(Answer answer :answers){
            answer.setAnswerContent(StringUtil.delHTMLTag(answer.getAnswerContent()));
            answer.setQuiz(publishAnswerMapper.selectQuizByQuizId(answer.getQuiz()));
        }
        return answers;
    }
}
