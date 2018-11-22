package com.utunan.service.community.impl;

import com.utunan.mapper.community.QuizMapper;
import com.utunan.pojo.community.Quiz;
import com.utunan.pojo.community.Tag;
import com.utunan.pojo.user.User;
import com.utunan.service.community.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * @author  孙程程
 * @description 问答
 * @date  16:02 2018/11/19
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
	public User findUserByQuizId(Long quizId){
		return this.quizMapper.findUserByQuizId(quizId);
	}
	@Override
	public Long countCommentByQuizId(Long quizId){
		return this.quizMapper.countCommentByQuizId(quizId);
	}
	@Override
	public List<Tag> selectTagByQuizId(Long quizId){
		return this.quizMapper.selectTagByQuizId(quizId);
	}
}
