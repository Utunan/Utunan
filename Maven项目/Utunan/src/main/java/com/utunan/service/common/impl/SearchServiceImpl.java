package com.utunan.service.common.impl;

import com.github.pagehelper.PageHelper;
import com.utunan.mapper.common.SearchMapper;
import com.utunan.pojo.base.community.Answer;
import com.utunan.pojo.base.community.Quiz;
import com.utunan.service.common.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("SearchService")
public class SearchServiceImpl implements SearchService {
	@Autowired
	private SearchMapper searchMapper;

	/**
	 * @author  孙程程
	 * @description 搜索提问
	 * @date  16:12 2018/11/27
	 * @param  keyWords, pageNum, pageSize
	 * @return  java.util.List<com.utunan.pojo.base.community.Answer>
	 */
	@Override
	public List<Quiz> findQuiz(List<String> keyWords, int pageNum, int pageSize){
		String keyWord="";
		for(int i=0; i<keyWords.size(); i++){
			keyWord += keyWords.get(i);
			if (i != (keyWords.size()-1)){
				keyWord += "|";
			}
		}
		PageHelper.startPage(pageNum,pageSize);
		List<Quiz> quizList=searchMapper.findQuiz(keyWord);
		return quizList;
	}
	/**
	 * @author  孙程程
     * @description 搜索回答
     * @date  16:12 2018/11/27
	 * @param  keyWords, pageNum, pageSize
     * @return  java.util.List<com.utunan.pojo.base.community.Answer>
     */
	@Override
	public List<Answer> findAnswer(List<String> keyWords, int pageNum, int pageSize){
		String keyWord="";
		for(int i=0; i<keyWords.size(); i++){
			keyWord += keyWords.get(i);
			if (i != (keyWords.size()-1)){
				keyWord += "|";
			}
		}
		PageHelper.startPage(pageNum,pageSize);
		List<Answer> answerList =searchMapper.findAnswer(keyWord);
		return answerList;
	}
}
