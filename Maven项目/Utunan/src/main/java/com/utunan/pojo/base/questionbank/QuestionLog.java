package com.utunan.pojo.base.questionbank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.utunan.pojo.base.user.User;

import java.util.Date;

/**
 * @author 王慧
 * @description: TODO
 * @date 2019/5/27 14:40
 */
public class QuestionLog {
    private static Logger log = LoggerFactory.getLogger(QuestionLog.class);
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
        log.info(userId+","+quizId+","+"1");
    }
}
