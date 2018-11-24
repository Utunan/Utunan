package com.utunan.service.community.impl;

import com.utunan.mapper.community.QuizMapper;
import com.utunan.pojo.community.Quiz;
import com.utunan.service.community.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public List<Long> countComment(int pageNum, int pageSize){
		return this.quizMapper.countComment((pageNum-1)*pageSize,pageSize);
	}
	/*
	 * @author  王碧云
	 * @description 根据quizId查找Quiz
	 * @date  12:36 2018/11/24
	 * @param  [quizId]
	 * @return  com.utunan.pojo.community.Quiz
	 */
	@Override
	public Quiz findQuizById(int quizId) {
		return this.quizMapper.findQuizById(quizId);
	}

}
