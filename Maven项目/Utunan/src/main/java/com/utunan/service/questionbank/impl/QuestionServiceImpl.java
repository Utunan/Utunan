package com.utunan.service.questionbank.impl;

import com.github.pagehelper.PageHelper;
import com.utunan.mapper.questionbank.QuestionSearchMapper;
import com.utunan.pojo.base.questionbank.Question;
import com.utunan.service.questionbank.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("questionService")
public class QuestionServiceImpl implements QuestionService {
	@Autowired
	private QuestionSearchMapper questionSearchMapper;

	/**
	 * @author  孙程程
	 * @description 搜索题目
	 * @date  16:11 2018/12/3
	 * @param  searchValue, pageNum, pageSize
	 * @return  java.util.List<com.utunan.pojo.base.questionbank.Question>
	 */
	@Override
	public List<Question> selectQuestionBySearchValue(String searchValue, int pageNum, int pageSize){
		PageHelper.startPage(pageNum,pageSize);
		//题目列表
		List<Question> questionList=this.questionSearchMapper.selectQuestionBySearchValue("%"+searchValue+"%");
		condenseQuestion(questionList);
		return questionList;
	}

	/**
	 * @author  孙程程
	 * @description 统计所有题目数量
	 * @date  16:52 2018/12/3
	 * @return  java.lang.Long
	 */
	@Override
	public Long countAllQuestion(){
		return this.questionSearchMapper.countAllQuestion();
	}

	/**
	 * @author  唐溪
	 * @description 限制问题标题、内容展示字数
	 * @date   18:55 2018/11/25
	 * @param
	 * @return  void
	 */
	public void condenseQuestion(List<Question> list) {
		for(int i=0;i<list.size();i++){
			Question q=list.get(i);
			if(q.getQuestionContent().length()>19){
				q.setQuestionContent(q.getQuestionContent().substring(0,19)+"...");
			}
		}
	}

}
