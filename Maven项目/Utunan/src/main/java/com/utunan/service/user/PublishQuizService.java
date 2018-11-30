package com.utunan.service.user;

import com.utunan.pojo.base.community.Quiz;
import com.utunan.pojo.base.user.User;
import com.utunan.pojo.inherit.user.PublishQuiz;

import java.util.List;

public interface PublishQuizService {
    List<PublishQuiz> getUserPublishQuiz(User user, int pageNum, int pageSize);
}

