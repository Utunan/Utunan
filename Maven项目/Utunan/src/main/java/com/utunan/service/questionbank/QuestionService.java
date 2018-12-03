package com.utunan.service.questionbank;

import com.utunan.pojo.base.questionbank.Question;

import java.util.List;

public interface QuestionService {
	/**
	 * @author  孙程程
	 * @description 搜索题目
	 * @date  16:11 2018/12/3
	 * @param  searchValue, pageNum, pageSize
	 * @return  java.util.List<com.utunan.pojo.base.questionbank.Question>
	 */
	List<Question> selectQuestionBySearchValue(String searchValue, int pageNum, int pageSize);

	/**
	 * @author  孙程程
	 * @description 统计所有题目数量
	 * @date  16:52 2018/12/3
	 * @return  java.lang.Long
	 */
	Long countAllQuestion();

}
