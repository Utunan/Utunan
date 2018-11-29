package com.utunan.service.community.impl;

import com.github.pagehelper.PageHelper;
import com.utunan.mapper.community.QuizMapper;
import com.utunan.pojo.community.Quiz;
import com.utunan.pojo.community.QuizTag;
import com.utunan.pojo.community.Tag;
import com.utunan.pojo.user.User;
import com.utunan.pojo.util.BigQuiz;
import com.utunan.service.community.QuizService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("quizService")
public class QuizServiceImpl implements QuizService {
	@Autowired
	private QuizMapper quizMapper;

	/**
	 * @author  孙程程
	 * @description 根据发表时间分页查询问答列表
	 * @date  16:20 2018/11/19
	 * @param  pageNum
	 * @param  pageSize
	 * @return  java.util.List<com.utunan.pojo.community.Quiz>
	 */
	@Override
	public List<Quiz> quizListByTime(int pageNum, int pageSize){
		PageHelper.startPage(pageNum,pageSize);
		//按发表时间的提问列表
		List<Quiz> quizList = quizMapper.listQuizByTime();
		//限制问题标题、内容展示字数
		condenseQuiz(quizList);
		return quizList;
	}
	
	/**
	 * @author  孙程程
	 * @description 根据点赞数量分页查询问答列表
	 * @date  17:15 2018/11/20
	 * @param  pageNum
	 * @param  pageSize
	 * @return  java.util.List<com.utunan.pojo.community.Quiz>
	 */
	@Override
	public List<Quiz> quizListByPraise(int pageNum, int pageSize){
		PageHelper.startPage(pageNum,pageSize);
		//按发表时间的提问列表
		List<Quiz> quizList = quizMapper.listQuizByPraise();
		//限制问题标题、内容展示字数
		condenseQuiz(quizList);
		return quizList;
	}
	
	@Override
	public Long countAllQuiz(){
		return this.quizMapper.countAllQuiz();
	}
	
	/*
	 * @author  张正扬
	 * @description 向quiz表插入问题
	 * @date  15:47 2018/11/22
	 * @param  title,content
	 * @return  null
	 */
	
	@Override
	public void saveQuiz(Long uid,String title,String content){
	    Quiz quiz=new Quiz();
	    quiz.setUserId(uid);
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
	
	/*
	 * @author  王碧云
	 * @description 根据quizId查找Quiz
	 * @date  12:36 2018/11/24
	 * @param  [quizId]
	 * @return  com.utunan.pojo.community.Quiz
	 */
	@Override
	public Quiz findQuizById(Long quizId) {
		return this.quizMapper.findQuizById(quizId);
	}
	/*
	 * @author  王碧云
	 * @description 根据quizId查评论数量
	 * @date  15:06 2018/11/25/025
	 * @param  [quizId]
	 * @return  java.lang.Long
	 */
	@Override
	public Long countCommentByQuizId(Long quizId) {
		return this.quizMapper.countCommentByQuizId(quizId);
	}
	
	/**
	 * @author  孙程程
	 * @description 根据quizId查标签列表
	 * @date  16:19 2018/11/28
	 * @param  quizId
	 * @return  java.util.List<com.utunan.pojo.community.Tag>
	 */
	@Override
	public List<Tag> selectTagByQuizId(Long quizId){
		return this.quizMapper.selectTagByQuizId(quizId);
	}
	
	/**
	 * @author  孙程程
	 * @description 在某标签下根据发表时间分页查询问答列表
	 * @date  8:46 2018/11/26
	 * @param  tagName, pageNum, pageSize
	 * @return  java.util.List<com.utunan.pojo.util.BigQuiz>
	 */
	@Override
	public List<Quiz> quizListByTimeWithTagName(String tagName, int pageNum, int pageSize){
		//某标签的quizId
		List<Long> quizId=quizMapper.selectQuizIdByTagName(tagName);
		PageHelper.startPage(pageNum,pageSize);
		//按发表时间的提问列表
		List<Quiz> quizList = quizMapper.listQuizByTimeWithTagName(quizId);
		//限制问题标题、内容展示字数
		condenseQuiz(quizList);
		return quizList;
	}
	
	/**
	 * @author  孙程程
	 * @description 在某标签下根据点赞数量分页查询问答列表
	 * @date  15:36 2018/11/26
	 * @param  tagName, pageNum, pageSize
	 * @return  java.util.List<com.utunan.pojo.util.BigQuiz>
	 */
	@Override
	public List<Quiz> quizListByPraiseWithTagName(String tagName, int pageNum, int pageSize){
		//某标签的quizId
		List<Long> quizId=quizMapper.selectQuizIdByTagName(tagName);
		PageHelper.startPage(pageNum,pageSize);
		//按点赞顺序的提问列表
		List<Quiz> quizList = quizMapper.listQuizByPraiseWithTagName(quizId);
		//限制问题标题、内容展示字数
		condenseQuiz(quizList);
		return quizList;
	}
	
	@Override
	public Long countQuizWithTagName(String tagName) {
		return this.quizMapper.countQuizWithTagName(tagName);
	}
	/**
	 * @author  唐溪
	 * @description 限制问题标题、内容展示字数
	 * @date   18:55 2018/11/25
	 * @param
	 * @return  void
	 */
		@Override
		public void condenseQuiz(List<Quiz> quizList) {
			for(int i=0;i<quizList.size();i++){
				Quiz q=quizList.get(i);
				if(q.getQuizContent().length()>95)
					q.setQuizContent(q.getQuizContent().substring(0,95)+" ...");
				if(q.getQuizTitle().length()>30)
					q.setQuizTitle(q.getQuizTitle().substring(0,30)+" ...");
			}
		}
	
	/**
	 * @author  孙程程
	 * @description 根据搜索条件查找提问列表
	 * @date  20:12 2018/11/26
	 * @param  searchValue
	 * @return  java.util.List<com.utunan.pojo.community.Quiz>
	 */
	@Override
	public List<Quiz> findQuizBySearch(String searchValue, int pageNum, int pageSize){
		PageHelper.startPage(pageNum,pageSize);
		//按提问列表
		List<Quiz> quizList = quizMapper.findQuizBySearch("%"+searchValue+"%");
		//限制问题标题、内容展示字数
		condenseQuiz(quizList);
		return quizList;
	}
	
	/**
	 * @author  孙程程
	 * @description 符合搜索条件的提问数量
	 * @date  21:19 2018/11/26
	 * @param  searchValue
	 * @return  java.lang.Long
	 */
	@Override
	public Long countQuizBySearch(String searchValue){
		return this.quizMapper.countQuizBySearch("%"+searchValue+"%");
	}
	
	/*
	 * @author  张正扬
	 * @description  更新点赞计数
	 * @date  21:32 2018/11/27
	 * @param  [quizId]
	 * @return  void
	 */
	@Override
	public void praiseQuiz(Long quizId) {
		System.out.print(quizId);
		this.quizMapper.updatePraiseCount(quizId);
	}
	
	/**
	 * @author  孙程程
	 * @description 通过quizId查找用户
	 * @date  20:15 2018/11/28
	 * @param  quizId
	 * @return  com.utunan.pojo.user.User
	 */
	@Override
	public User findUserByQuizId(Long quizId){
		return this.quizMapper.findUserByQuizId(quizId);

	}

	@Override
	public Long getMaxQid(){
		return this.quizMapper.getMax();

	}

}


