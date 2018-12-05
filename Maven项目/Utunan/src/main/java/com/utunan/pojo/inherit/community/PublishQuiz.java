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

    public void setAnswer(List<Answer> answers) {
        this.answers = answers;
    }


    @Override
    public String toString() {
        return "PublishQuiz{" +
                "answers=" + answers +
                '}';
    }
}
