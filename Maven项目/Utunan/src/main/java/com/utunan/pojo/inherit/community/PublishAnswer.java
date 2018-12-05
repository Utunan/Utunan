package com.utunan.pojo.inherit.community;

import com.utunan.pojo.base.community.Answer;

import java.util.List;

/**
 * @author 张正扬
 * @description: TODO
 * @date 2018/12/5 17:56
 */
public class PublishAnswer {
    private List<Answer> answers;

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }


    @Override
    public String toString() {
        return "PublishAnswer{" +
                "answers=" + answers +
                '}';
    }
}
