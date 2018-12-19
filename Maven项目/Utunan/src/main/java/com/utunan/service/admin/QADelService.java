package com.utunan.service.admin;

public interface QADelService {
    //批量删除提问
    void delAllQuiz(Long[] b);

    //批量删除回答评论
    void delAllAnswer(Long[] b);

    //单个删除提问
    void delQuiz(Long quizId);

    //删除单个回答评论
     void delAnswer(Long answerId);
}
