package com.utunan.service.user;

import com.utunan.pojo.community.Quiz;
import com.utunan.pojo.user.User;

import java.util.List;

public interface PublishQuizService {
    List<Quiz> getUserPublishQuiz(User user, int pageNum, int pageSize);
}

