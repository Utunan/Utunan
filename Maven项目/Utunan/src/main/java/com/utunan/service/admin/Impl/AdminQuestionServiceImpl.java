package com.utunan.service.admin.Impl;

import com.github.pagehelper.PageHelper;
import com.utunan.mapper.admin.AdminQuestionMapper;
import com.utunan.pojo.base.questionbank.Question;
import com.utunan.service.admin.AdminQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("adminQuestionService")
public class AdminQuestionServiceImpl implements AdminQuestionService {

    @Autowired
    private AdminQuestionMapper adminQuestionMapper;


    @Override
    public List<Question> getAllDS(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Question> questions=adminQuestionMapper.selectAllDS();
        return questions;
    }

    @Override
    public List<Question> getAllC(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Question> questions=adminQuestionMapper.selectAllC();
        return questions;
    }

    @Override
    public List<Question> getAllNetwork(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Question> questions=adminQuestionMapper.selectAllNetwork();
        return questions;
    }

    @Override
    public List<Question> getAllOS(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Question> questions=adminQuestionMapper.selectAllOS();
        return questions;
    }

    @Override
    public List<Question> getAllConstitute(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Question> questions=adminQuestionMapper.selectAllConstitute();
        return questions;
    }

    @Override
    public List<Question> getAllSE(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Question> questions=adminQuestionMapper.selectAllSE();
        return questions;
    }

    @Override
    public List<Question> getQuestionByKeyword(String keyword) {
        return null;
    }
}
