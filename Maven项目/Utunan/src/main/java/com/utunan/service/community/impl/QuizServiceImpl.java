package com.utunan.service.community.impl;

import com.utunan.mapper.community.QuizMapper;
import com.utunan.pojo.community.Quiz;
import com.utunan.pojo.community.Tag;
import com.utunan.pojo.user.User;
import com.utunan.pojo.util.BigQuiz;
import com.utunan.service.community.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("quizService")
public class QuizServiceImpl implements QuizService {
	@Autowired
	private QuizMapper quizMapper;

	@Override
	public List<BigQuiz> quizListByTime(int pageNum, int pageSize){
		//按发表时间的提问列表
		List<Quiz> quizListByTime = quizMapper.listQuizByTime((pageNum-1)*pageSize,pageSize);
		//提取quizId列表
		List<Long> quizIdList=new ArrayList<>();
		for(int i=0; i<quizListByTime.size(); i++){
			quizIdList.add(quizListByTime.get(i).getQuizId());
		}
		//获取提问的评论数量列表
		List<Long> commentNumberByTime=new ArrayList<>();
//		List<Long> commentNumberByTime=quizMapper.countCommentNumberByTime((pageNum-1)*pageSize,pageSize);
		//获取评论的标签列表
		List<List<Tag>> quizTagList=new ArrayList<>();
		for(int i=0; i<quizListByTime.size(); i++){
			commentNumberByTime.add(quizMapper.countCommentByQuizId(quizIdList.get(i)));
			quizTagList.add(quizMapper.selectTagByQuizId(quizIdList.get(i)));
		}
		//将提问、评论数量、标签封装
		List<BigQuiz> objects=new ArrayList<>();
		for (int i=0;i<quizListByTime.size(); i++){
			BigQuiz bigQuiz=new BigQuiz();
			bigQuiz.setQuiz(quizListByTime.get(i));
			bigQuiz.setCommentNumber(commentNumberByTime.get(i));
			bigQuiz.setTagList(quizTagList.get(i));
			objects.add(bigQuiz);
		}
		return objects;
	}
	@Override
	public List<BigQuiz> quizListByPraise(int pageNum, int pageSize){
		//按点赞顺序的提问列表
		List<Quiz> quizListByPraise = quizMapper.listQuizByPraise((pageNum-1)*pageSize,pageSize);
		//提取quizId列表
		List<Long> quizIdList=new ArrayList<>();
		for(int i=0; i<quizListByPraise.size(); i++){
			quizIdList.add(quizListByPraise.get(i).getQuizId());
		}
		//获取提问的评论数量列表
		List<Long> commentNumberByPraise=new ArrayList<>();
//		List<Long> commentNumberByPraise=quizMapper.countCommentNumberByPraise((pageNum-1)*pageSize,pageSize);
		//获取提问的标签列表
		List<List<Tag>> quizTagList=new ArrayList<>();
		for(int i=0; i<quizListByPraise.size(); i++){
			commentNumberByPraise.add(quizMapper.countCommentByQuizId(quizIdList.get(i)));
			quizTagList.add(quizMapper.selectTagByQuizId(quizIdList.get(i)));
		}
		//将提问、评论数量、标签封装
		List<BigQuiz> objects=new ArrayList<>();
		for (int i=0;i<quizListByPraise.size(); i++){
			BigQuiz bigQuiz=new BigQuiz();
			bigQuiz.setQuiz(quizListByPraise.get(i));
			bigQuiz.setCommentNumber(commentNumberByPraise.get(i));
			bigQuiz.setTagList(quizTagList.get(i));
			objects.add(bigQuiz);
		}
		return objects;
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

}
