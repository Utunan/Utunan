package com.utunan.service.community.impl;

import com.utunan.mapper.community.QuizCollectMapper;
import com.utunan.pojo.base.community.Quiz;
import com.utunan.pojo.base.user.QuizCollector;
import com.utunan.pojo.base.user.User;
import com.utunan.service.community.QuizCollectService;
import com.utunan.service.user.QuizCollectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 张正扬
 * @description: TODO
 * @date 2018/12/6 16:14
 */
@Service("QuizCollectService")
public class QuizCollectServiceImpl implements QuizCollectService {

    @Autowired
    private QuizCollectMapper quizCollectMapper;

    @Override
    public void insertQuizCollector(Long qcid, User user, Quiz quiz){
        QuizCollector quizCollector=new QuizCollector();
        quizCollector.setQuizCollectorId(qcid);
        quizCollector.setUser(user);
        quizCollector.setQuiz(quiz);

        quizCollectMapper.insertQuizCollector(quizCollector);

    }


    @Override
    public Long getMaxQCid(){
        return quizCollectMapper.getMaxQCid();
    }

    @Override
    public QuizCollector getQuizCollector(Long quizId, Long userId) {
        return this.quizCollectMapper.getQuizCollector(quizId,userId);
    }

    @Override
    public void delQuizCollector(Long quizId, Long userId) {
        this.quizCollectMapper.delQuizCollector(quizId,userId);
    }

//    获得用户收藏的quiz
    @Override
    public List <Long> getAllQuizId(Long userId) {
        return this.quizCollectMapper.getAllQuizId(userId);
    }
}
