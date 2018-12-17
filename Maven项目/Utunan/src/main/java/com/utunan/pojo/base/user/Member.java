package com.utunan.pojo.base.user;

import com.utunan.pojo.base.community.Quiz;
import com.utunan.pojo.base.questionbank.Question;

import java.util.List;

public class Member {
    private User user;
    private List<User> users;
    private List<Quiz> quizzes;
    private List<Question> questions;
    private boolean isfollow;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Quiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(List<Quiz> quizzes) {
        this.quizzes = quizzes;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public boolean isIsfollow() {
        return isfollow;
    }

    public void setIsfollow(boolean isfollow) {
        this.isfollow = isfollow;
    }

    @Override
    public String toString() {
        return "Member{" +
                "user=" + user +
                ", users=" + users +
                ", quizzes=" + quizzes +
                ", questions=" + questions +
                ", isfollow=" + isfollow +
                '}';
    }
}
