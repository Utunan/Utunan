package com.utunan.service.community;

import com.utunan.pojo.base.community.Quiz;
import com.utunan.pojo.base.user.QuizCollector;
import com.utunan.pojo.base.user.User;
import org.springframework.stereotype.Service;

/**
 * @author 张正扬
 * @description: TODO
 * @date 2018/12/6 16:13
 */

public interface QuizCollectService {
    void insertQuizCollector(Long qcid, User user, Quiz quiz);

    Long getMaxQCid();

    //获取QuizCollector表中信息
    QuizCollector getQuizCollector(Long quizId, Long userId);

    //删除用户收藏
    void delQuizCollector(Long quizId, Long userId);
}
