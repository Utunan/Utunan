package com.utunan.pojo.inherit.community;

import com.utunan.pojo.base.community.Answer;
import com.utunan.pojo.base.community.Quiz;

import java.util.List;

/**
 * @author 张正扬
 * @description: TODO
 * @date 2018/12/2 21:01
 */
public class PublishQuiz extends Quiz {
    private List<Answer> answer;

    public List<Answer> getAnswer() {
        return answer;
    }

    public void setAnswer(List<Answer> answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "PublishQuiz{" +
                "answer=" + answer +
                '}';
    }
}
