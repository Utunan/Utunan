package com.utunan.service.community.impl;

import com.utunan.mapper.community.QuizGreatMapper;
import com.utunan.pojo.base.community.QuizGreat;
import com.utunan.service.community.QuizGreatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 张正扬
 * @description: TODO
 * @date 2018/12/8 14:11
 */
@Service("QuizGreatService")
public class QuizGreatServiceImpl implements QuizGreatService {
    @Autowired
    private QuizGreatMapper quizGreatMapper;
    @Override
    public QuizGreat getQuizGreat(Long quizId, Long userId) {
        return quizGreatMapper.getQuizGreat(quizId,userId);
    }

    @Override
    public void addQuizGreat(Long quizId, Long userId) {
        quizGreatMapper.addQuizGreat(quizId,userId);
    }

    @Override
    public void delQuizGreat(Long quizId, Long userId) {
        quizGreatMapper.delQuizGreat(quizId,userId);
    }
}
