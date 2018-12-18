package com.utunan.service.admin;

import com.utunan.pojo.base.community.Answer;

import java.util.List;

public interface AdminAnswerService {
    //获得所有回答评论
    List<Answer> getAllAnswer(int pageNum, int pageSize);
}
