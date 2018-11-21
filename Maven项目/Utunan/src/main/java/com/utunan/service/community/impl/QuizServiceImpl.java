package com.utunan.service.community.impl;

import com.utunan.mapper.community.QuizMapper;
import com.utunan.pojo.community.Quiz;
import com.utunan.service.community.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	@Autowired
	private Quiz quiz;

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
		Long count = quizMapper.countAllQuiz();
		return count;
	}

	/*
	 * @author  张正扬
	 * @description  向Quiz表插入问答
	 * @date  13:37 2018/11/21
	 * @param   title,content
	 * @return  null
	 */

	@Override
	public void saveQuiz(String title,String content){
		quiz.setQuizTitle(title);
		quiz.setReleaseTime(new Date());
		quiz.setQuizContent(content);
		quizMapper.toInsert(quiz);
	}

	@Override
	public Quiz getQuiz(String title,String content){
		return quizMapper.getQuiz(title,content);
	}

}
