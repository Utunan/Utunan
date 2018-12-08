package com.utunan.service.admin.Impl;

import com.github.pagehelper.PageHelper;
import com.utunan.mapper.admin.AdminQuizMapper;
import com.utunan.pojo.base.community.Quiz;
import com.utunan.service.admin.AdminQuizService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AdminQuizServiceImpl implements AdminQuizService {

    @Autowired
    private AdminQuizMapper adminQuizMapper;

    @Override
    public List<Quiz> getAllQuiz(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Quiz> quizzes=adminQuizMapper.selectAllQuiz();
        return  quizzes;
    }
}
