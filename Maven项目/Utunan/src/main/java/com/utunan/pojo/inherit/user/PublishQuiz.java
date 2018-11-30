package com.utunan.pojo.inherit.user;



import com.utunan.pojo.base.community.Quiz;
import com.utunan.pojo.base.user.User;

import java.util.List;

public class PublishQuiz extends User {

    private List<Quiz> quizzes;

    public List<Quiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(List<Quiz> quizList) {
        this.quizzes = quizList;
    }

    @Override
    public String toString() {
        return "QuizCollector{" +
                "quizzes=" + quizzes +
                '}';
    }
}
