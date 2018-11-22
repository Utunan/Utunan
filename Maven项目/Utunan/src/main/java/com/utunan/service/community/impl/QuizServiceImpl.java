package com.utunan.service.community.impl;

import com.utunan.mapper.community.QuizMapper;
import com.utunan.pojo.community.Quiz;
import com.utunan.pojo.user.User;
import com.utunan.service.community.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * @author  孙程程
 * @description 问答
 * @date  16:02 2018/11/19
 * @param
 * @return
 */
@Service("quizService")
public class QuizServiceImpl implements QuizService {
	@Autowired
	private QuizMapper quizMapper;

	@Override
	public List<Quiz> getQuizByTime(int pageNum, int pageSize){
		List quizByTime = quizMapper.listByTime((pageNum-1)*pageSize,pageSize);
		return quizByTime;
	}
	@Override
	public List<Quiz> getQuizByPraise(int pageNum, int pageSize){
		List quizByPraise = quizMapper.listByPraise((pageNum-1)*pageSize,pageSize);
		return quizByPraise;
	}
	@Override
	public Long countAllQuiz(){
		return this.quizMapper.countAllQuiz();
	}
	@Override
	public List<Long> countCommentByTime(int pageNum, int pageSize){
		return this.quizMapper.countCommentByTime((pageNum-1)*pageSize,pageSize);
	}
	@Override
	public List<Long> countCommentByPraise(int pageNum, int pageSize){
		return this.quizMapper.countCommentByPraise((pageNum-1)*pageSize,pageSize);
	}
//	@Override
//	public User findUserByQuizId(Long quizId){
//		return this.quizMapper.findUserByQuizId(quizId);
//	}

	/*
	 * @author  张正扬
	 * @description 向quiz表插入问题
	 * @date  15:47 2018/11/22
	 * @param  title,content
	 * @return  null
	 */

	@Override
	public void saveQuiz(String title,String content){
		Quiz quiz=new Quiz();
		int k=253;
		long f=(long)k;
		quiz.setUserId(f);
		quiz.setQuizTitle(title);
		quiz.setQuizContent(content);
		quiz.setReleaseTime(new Date());
		int i=0;
		long j=(long) i;
		quiz.setPraiseCount(j);
		quizMapper.toInsert(quiz);
	}

	/*
	 * @author  张正扬
	 * @description 从quiz表取出刚刚插入的问题
	 * @date  15:47 2018/11/22
	 * @param  null
	 * @return  Quiz对象
	 */

	@Override
	public Quiz getQuiz(){
		Quiz q= quizMapper.getQuiz1();
		return q;
	}
}
