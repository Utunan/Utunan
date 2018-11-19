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

	/**
	 * @author  孙程程
	 * @description 根据发表时间分页查询问答列表
	 * @date  16:20 2018/11/19
	 * @param  [pageNum,pageSize]
	 * @return  java.util.List<com.utunan.pojo.community.Quiz>
	 */
	@Override
	public List<Quiz> getQuizByTime(int pageNum, int pageSize){
		List quizByTime = quizMapper.listByTime(pageNum,pageSize);
		return quizByTime;
	}

	/**
	 * @author  孙程程
	 * @description 所有问答数量
	 * @date  20:16 2018/11/19
	 * @return  java.lang.Long
	 */
	@Override
	public Long countAllQuiz(){
		Long count = quizMapper.countAllQuiz();
		return count;
	}

}
