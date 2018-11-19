package com.utunan.service.community.impl;

import com.utunan.pojo.community.Quiz;
import com.utunan.service.community.QuizService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("articleService")
public class QuizServiceImpl implements QuizService {

    public int insert(Quiz quiz){
        return  0;
    }
     public List<Quiz> queryByPlate(String plateId){
        return  null;
     }

}
