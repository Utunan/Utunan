package com.utunan.service.admin;

import com.utunan.pojo.base.community.Quiz;

import java.util.List;

public interface AdminQuizService {
    List<Quiz> getAllQuiz(int pageNum,int pageSize);
}
