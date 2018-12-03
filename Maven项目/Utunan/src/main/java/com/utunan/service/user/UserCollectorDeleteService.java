package com.utunan.service.user;

import com.utunan.pojo.base.user.User;

public interface UserCollectorDeleteService {

    boolean deleteQuizCollector(Long userId,String quizId);
    boolean deleteQuestionCollector(Long userId,String questionId);
    boolean deleteDirectionCollector(Long userId,String directionId);

}
