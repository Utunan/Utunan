package com.utunan.service.user;

import com.utunan.pojo.base.questionbank.Question;
import com.utunan.pojo.base.user.User;

import java.util.List;

public interface QuestionCollectorService {
    List<Question> getQuestionCollector(User user, int pageNum, int pageSize);
}
