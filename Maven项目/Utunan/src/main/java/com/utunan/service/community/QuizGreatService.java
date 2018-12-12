package com.utunan.service.community;

import com.utunan.pojo.base.community.QuizGreat;

/**
 * @author 张正扬
 * @description: TODO
 * @date 2018/12/8 14:10
 */
public interface QuizGreatService {
    //查询QuizGreat表信息
    QuizGreat getQuizGreat(Long quizId, Long userId);

    //插入QuizGreat表信息
    void addQuizGreat(Long quizId, Long userId);

    //删除QuizGreat表信息
    void delQuizGreat(Long quizId, Long userId);
}
