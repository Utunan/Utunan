package com.utunan.service.community.impl;

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


import java.util.*;

@Service("quizService")
public class QuizServiceImpl implements QuizService {
	@Autowired
	private QuizMapper quizMapper;

	@Override
	public List<BigQuiz> quizListByTime(int pageNum, int pageSize){
		//按发表时间的提问列表

		List<Quiz> quizListByTime = quizMapper.listQuizByTime((pageNum-1)*pageSize,pageSize);
		System.out.print(quizListByTime);
		//限制问题标题、内容展示字数
		condenseQuiz(quizListByTime);
		//提取quizId列表
		List<Long> quizIdList=new ArrayList<>();
		for(int i=0; i<quizListByTime.size(); i++){
			quizIdList.add(quizListByTime.get(i).getQuizId());
		}
		//获取提问的评论数量列表
		List<Long> commentNumber=new ArrayList<>();
//		List<Long> commentNumber=quizMapper.countCommentNumberByTime((pageNum-1)*pageSize,pageSize);
		//获取评论的标签列表
		List<List<Tag>> quizTagList=new ArrayList<>();
		for(int i=0; i<quizListByTime.size(); i++){
			commentNumber.add(quizMapper.countCommentByQuizId(quizIdList.get(i)));
			quizTagList.add(quizMapper.selectTagByQuizId(quizIdList.get(i)));
		}
		//将提问、评论数量、标签封装
		List<BigQuiz> objects=new ArrayList<>();
		for (int i=0;i<quizListByTime.size(); i++){
			BigQuiz bigQuiz=new BigQuiz();
			bigQuiz.setQuiz(quizListByTime.get(i));
			bigQuiz.setUser(quizListByTime.get(i).getUser());
			bigQuiz.setCommentNumber(commentNumber.get(i));
			bigQuiz.setTagList(quizTagList.get(i));
			objects.add(bigQuiz);
		}
		return objects;
	}
	@Override
	public List<BigQuiz> quizListByPraise(int pageNum, int pageSize){
		//按点赞顺序的提问列表
		List<Quiz> quizListByPraise = quizMapper.listQuizByPraise((pageNum-1)*pageSize,pageSize);
		//限制问题标题、内容展示字数
		condenseQuiz(quizListByPraise);
		//提取quizId列表
		List<Long> quizIdList=new ArrayList<>();
		for(int i=0; i<quizListByPraise.size(); i++){
			quizIdList.add(quizListByPraise.get(i).getQuizId());
		}
		//获取提问的评论数量列表
		List<Long> commentNumber=new ArrayList<>();
//		List<Long> commentNumber=quizMapper.countCommentNumberByPraise((pageNum-1)*pageSize,pageSize);
		//获取提问的标签列表
		List<List<Tag>> quizTagList=new ArrayList<>();
		for(int i=0; i<quizListByPraise.size(); i++){
			commentNumber.add(quizMapper.countCommentByQuizId(quizIdList.get(i)));
			quizTagList.add(quizMapper.selectTagByQuizId(quizIdList.get(i)));
		}
		//将提问、评论数量、标签封装
		List<BigQuiz> objects=new ArrayList<>();
		for (int i=0;i<quizListByPraise.size(); i++){
			BigQuiz bigQuiz=new BigQuiz();
			bigQuiz.setQuiz(quizListByPraise.get(i));
			bigQuiz.setUser(quizListByPraise.get(i).getUser());
			bigQuiz.setCommentNumber(commentNumber.get(i));
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
    public void saveQuiz(Long qid,Long uid,String title,String content){
        Quiz quiz=new Quiz();
        quiz.setQuizId(qid);
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

	@Override
	public List<BigQuiz> quizListByTimeWithTagName(String tagName, int pageNum, int pageSize){
		//某标签的quizId
		List<Long> quizId=quizMapper.selectQuizIdByTagName(tagName);
		//按点赞顺序的提问列表
		List<Quiz> quizListByTime = quizMapper.listQuizByTimeWithTagName(quizId, (pageNum-1)*pageSize,pageSize);
		//限制问题标题、内容展示字数
		condenseQuiz(quizListByTime);
		//提取quizId列表
		List<Long> quizIdList=new ArrayList<>();
		for(int i=0; i<quizListByTime.size(); i++){
			quizIdList.add(quizListByTime.get(i).getQuizId());
		}
		//获取提问的用户信息
		List<User> userList=new ArrayList<>();
		//获取提问的评论数量列表
		List<Long> commentNumber=new ArrayList<>();
		//获取提问的标签列表
		List<List<Tag>> quizTagList=new ArrayList<>();
		for(int i=0; i<quizListByTime.size(); i++){
			userList.add(quizMapper.findUserByQuizId(quizIdList.get(i)));
			commentNumber.add(quizMapper.countCommentByQuizId(quizIdList.get(i)));
			quizTagList.add(quizMapper.selectTagByQuizId(quizIdList.get(i)));
		}
		//将提问、评论数量、标签封装
		List<BigQuiz> objects=new ArrayList<>();
		for (int i=0;i<quizListByTime.size(); i++){
			BigQuiz bigQuiz=new BigQuiz();
			bigQuiz.setQuiz(quizListByTime.get(i));
			bigQuiz.setUser(userList.get(i));
			bigQuiz.setCommentNumber(commentNumber.get(i));
			bigQuiz.setTagList(quizTagList.get(i));
			objects.add(bigQuiz);
		}
		return objects;
	}

	@Override
	public List<BigQuiz> quizListByPraiseWithTagName(String tagName, int pageNum, int pageSize){
		//某标签的quizId
		List<Long> quizId=quizMapper.selectQuizIdByTagName(tagName);
		//按点赞顺序的提问列表
		List<Quiz> quizListByPraise = quizMapper.listQuizByPraiseWithTagName(quizId, (pageNum-1)*pageSize,pageSize);
		//限制问题标题、内容展示字数
		condenseQuiz(quizListByPraise);
		//提取quizId列表
		List<Long> quizIdList=new ArrayList<>();
		for(int i=0; i<quizListByPraise.size(); i++){
			quizIdList.add(quizListByPraise.get(i).getQuizId());
		}
		//获取提问的用户信息
		List<User> userList=new ArrayList<>();
		//获取提问的评论数量列表
		List<Long> commentNumber=new ArrayList<>();
		//获取提问的标签列表
		List<List<Tag>> quizTagList=new ArrayList<>();
		for(int i=0; i<quizListByPraise.size(); i++){
			userList.add(quizMapper.findUserByQuizId(quizIdList.get(i)));
			commentNumber.add(quizMapper.countCommentByQuizId(quizIdList.get(i)));
			quizTagList.add(quizMapper.selectTagByQuizId(quizIdList.get(i)));
		}
		//将提问、评论数量、标签封装
		List<BigQuiz> objects=new ArrayList<>();
		for (int i=0;i<quizListByPraise.size(); i++){
			BigQuiz bigQuiz=new BigQuiz();
			bigQuiz.setQuiz(quizListByPraise.get(i));
			bigQuiz.setUser(userList.get(i));
			bigQuiz.setCommentNumber(commentNumber.get(i));
			bigQuiz.setTagList(quizTagList.get(i));
			objects.add(bigQuiz);
		}
		return objects;
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

	@Override
	public List<BigQuiz> findQuizBySearch(String searchValue, int pageNum, int pageSize){
		//按提问列表
		List<Quiz> quizListByPraise = quizMapper.findQuizBySearch("%"+searchValue+"%", (pageNum-1)*pageSize,pageSize);
		//限制问题标题、内容展示字数
		condenseQuiz(quizListByPraise);
		//提取quizId列表
		List<Long> quizIdList=new ArrayList<>();
		for(int i=0; i<quizListByPraise.size(); i++){
			quizIdList.add(quizListByPraise.get(i).getQuizId());
		}
		//获取提问的评论数量列表
		List<Long> commentNumber=new ArrayList<>();
		//获取提问的标签列表
		List<List<Tag>> quizTagList=new ArrayList<>();
		for(int i=0; i<quizListByPraise.size(); i++){
			commentNumber.add(quizMapper.countCommentByQuizId(quizIdList.get(i)));
			quizTagList.add(quizMapper.selectTagByQuizId(quizIdList.get(i)));
		}
		//将提问、评论数量、标签封装
		List<BigQuiz> objects=new ArrayList<>();
		for (int i=0;i<quizListByPraise.size(); i++){
			BigQuiz bigQuiz=new BigQuiz();
			bigQuiz.setQuiz(quizListByPraise.get(i));
			bigQuiz.setUser(quizListByPraise.get(i).getUser());
			bigQuiz.setCommentNumber(commentNumber.get(i));
			bigQuiz.setTagList(quizTagList.get(i));
			objects.add(bigQuiz);
		}
		return objects;
	}

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



	/*
	 * @author  张正扬
	 * @description
	 * @date  18:02 2018/11/28
	 * @param  []
	 * @return  java.lang.Long
	 */
	@Override
	public Long getMaxQid() {

		return this.quizMapper.getMax();
	}
}


