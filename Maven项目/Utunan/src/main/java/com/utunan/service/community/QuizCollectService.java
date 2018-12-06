package com.utunan.service.community;

import com.utunan.pojo.base.community.Quiz;
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
}
