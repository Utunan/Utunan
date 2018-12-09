package com.utunan.service.common;

import com.utunan.pojo.base.community.Answer;
import com.utunan.pojo.base.community.Quiz;
import com.utunan.pojo.base.community.Tag;

import java.util.List;

public interface SearchService {
	/**
	 * @author  孙程程
	 * @description 根据搜索条件返回提问列表
	 * @date  16:12 2018/11/27
	 * @param  keyWords, pageNum, pageSize
	 * @return  java.util.List<com.utunan.pojo.base.community.Answer>
	 */
	List<Quiz> findQuiz(List<String> keyWords, int pageNum, int pageSize);
	/**
	 * @author  孙程程
	 * @description 根据搜索条件返回回答列表
	 * @date  16:12 2018/11/27
	 * @param  keyWords, pageNum, pageSize
	 * @return  java.util.List<com.utunan.pojo.base.community.Answer>
	 */
	List<Answer> findAnswer(List<String> keyWords, int pageNum, int pageSize);
}
