package com.utunan.service.user.impl;

import com.utunan.mapper.user.DirectionCollectorMapper;
import com.utunan.mapper.user.QuestionCollectorMapper;
import com.utunan.mapper.user.QuizCollectorMapper;
import com.utunan.pojo.base.user.User;
import com.utunan.service.user.UserCollectorDeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("uollectorDeleteService")
public class UserCollectorDeleteServiceImpl implements UserCollectorDeleteService {

    @Autowired
    private QuizCollectorMapper quizCollectorMapper;
    @Autowired
    private QuestionCollectorMapper questionCollectorMapper;
    @Autowired
    private DirectionCollectorMapper directionCollectorMapper;


    @Override
    public boolean deleteQuizCollector(Long userId, String quizId) {
        quizCollectorMapper.deleteQuizCollector(userId, quizId);
        return true;
    }

    @Override
    public boolean deleteQuestionCollector(Long userId, String questionId) {
        questionCollectorMapper.deleteQuestionCollector(userId, questionId);
        return true;
    }

    @Override
    public boolean deleteDirectionCollector(Long userId, String directionId) {
        directionCollectorMapper.deleteDirectionCollector(userId, directionId);
        return true;
    }
}
