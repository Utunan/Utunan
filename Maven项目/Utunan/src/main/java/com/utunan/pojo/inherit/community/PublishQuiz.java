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
    private List<Answer> answers;

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answer) {
        this.answers = answer;
    }

    @Override
    public String toString() {
        return "PublishQuiz{" +
                "answers=" + answers +
                '}';
    }
}
