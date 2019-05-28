package com.utunan.pojo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;

/**
 * @author 王慧
 * @description: TODO
 * @date 2019/5/28 10:37
 */
public class QuizLog {

    private static Logger log = LoggerFactory.getLogger(QuizLog.class);
    SimpleDateFormat df;
    private Long quizId;
    private Long userId;
    private String time;

    public Long getQuizId() {
        return quizId;
    }
    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }

    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }

    public void logsth() {
        log.info(userId+"  "+quizId+"  "+time);
    }
}
