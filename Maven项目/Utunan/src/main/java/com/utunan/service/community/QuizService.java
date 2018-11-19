package com.utunan.service.community;

import com.utunan.pojo.community.Quiz;

import java.util.List;

public interface QuizService {

    int insert(Quiz quiz);
    List<Quiz> queryByPlate(String plateId);

}
