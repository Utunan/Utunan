package com.utunan.service.admin.Impl;

import com.github.pagehelper.PageHelper;
import com.utunan.mapper.admin.AdminAnswerMapper;
import com.utunan.pojo.base.community.Answer;
import com.utunan.service.admin.AdminAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("AdminAnswerService")
public class AdminAnswerServiceImpl implements AdminAnswerService {
    @Autowired
    private AdminAnswerMapper answerMapper;

    //获得所有回答评论
    @Override
    public List <Answer> getAllAnswer(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List <Answer> answers= answerMapper.getAllAnswer();
        return answers;
    }
}
