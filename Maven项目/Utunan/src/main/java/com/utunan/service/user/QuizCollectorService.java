package com.utunan.service.user;

import com.utunan.pojo.base.community.Quiz;
import com.utunan.pojo.base.user.User;

import java.util.List;

public interface QuizCollectorService {
    List<Quiz> getQuizCollector(User user,int pageNum,int pageSize);
}
