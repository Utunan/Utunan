package com.utunan.service.admin.Impl;

import com.utunan.mapper.admin.QADelMapper;
import com.utunan.service.admin.QADelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("QADelService")
public class QADelServiceImpl implements QADelService {
    @Autowired
    private QADelMapper qaDelMapper;
    //批量删除提问
    @Override
    public void delAllQuiz(Long[] b) {
        qaDelMapper.delAllQuiz(b);
    }

    //批量删除回答评论
    @Override
    public void delAllAnswer(Long[] b) {
        qaDelMapper.delAllAnswer(b);
    }
}
