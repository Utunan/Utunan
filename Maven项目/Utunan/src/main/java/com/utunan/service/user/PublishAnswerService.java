package com.utunan.service.user;

import com.utunan.pojo.base.community.Answer;
import com.utunan.pojo.base.user.User;

import java.util.List;

public interface PublishAnswerService {
    List<Answer> getPublishAnswer(User user, int pageNum, int pageSize);
}
