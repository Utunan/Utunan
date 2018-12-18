package com.utunan.service.admin.Impl;

import com.utunan.mapper.admin.QuestionDelMapper;
import com.utunan.service.admin.QuestionDelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("QuestionDelService")
public class QuestionDelServiceImpl implements QuestionDelService {
    @Autowired
    private QuestionDelMapper questionDelMapper;

    //批量删除数据结构题目
    @Override
    public void delAllDsQuestion(Long[] b) {
        questionDelMapper.delAllDsQuestion(b);
    }


    //批量删除C语言题目
    @Override
    public void delAllCQuestion(Long[] b) {
        questionDelMapper.delAllCQuestion(b);
    }


    //批量删除操作系统题目
    @Override
    public void delAllOsQuestion(Long[] b) {
        questionDelMapper.delAllOsQuestion(b);
    }

    //批量删除组成原理题目

    @Override
    public void delAllConstitute(Long[] b) {
        questionDelMapper.delAllConstitute(b);
    }

    //批量删除网络原理题目
    @Override
    public void delAllNetwork(Long[] b) {
        questionDelMapper.delAllNetwork(b);
    }

    //批量删除软件工程题目
    @Override
    public void delAllSeQuestion(Long[] b) {
        questionDelMapper.delAllSeQuestion(b);
    }
}
