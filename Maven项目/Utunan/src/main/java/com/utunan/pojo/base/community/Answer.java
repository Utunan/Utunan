package com.utunan.pojo.base.community;

import com.utunan.pojo.base.user.User;

import java.util.Date;
import java.util.List;

/**
 * 评论表-Answer
 */
public class Answer {
	//评论ID
	private Long answerId;
	//评论内容
	private String answerContent;
	//提问
	private Quiz quiz;
	//用户
	private User user;
	//评论时间
	private Date answerTime;
	//点赞个数
	private  Long praiseCount;
	//父级评论
	private Long parentAnswer;

	private List<Answer> answer;

    public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getAnswerTime() {
        return answerTime;
    }

    public void setAnswerTime(Date answerTime) {
        this.answerTime = answerTime;
    }

    public Long getPraiseCount() {
        return praiseCount;
    }

    public void setPraiseCount(Long answerPraiseCount) {
        this.praiseCount = answerPraiseCount;
    }

    public Long getParentAnswer() {
        return parentAnswer;
    }

    public void setParentAnswer(Long parentAnswer) {
        this.parentAnswer = parentAnswer;
    }

    public List<Answer> getAnswer() {
        return answer;
    }

    public void setAnswer(List<Answer> answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answerId=" + answerId +
                ", answerContent='" + answerContent + '\'' +
                ", quiz=" + quiz +
                ", user=" + user +
                ", answerTime=" + answerTime +
                ", praiseCount=" + praiseCount +
                ", parentAnswer=" + parentAnswer +
                ", answer=" + answer +
                '}';
    }
}

