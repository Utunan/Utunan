package com.utunan.service.questionbank.impl;

import com.github.pagehelper.PageHelper;
import com.utunan.mapper.questionbank.QuestionIndexMapper;
import com.utunan.pojo.base.community.Quiz;
import com.utunan.pojo.base.questionbank.Question;
import com.utunan.pojo.base.questionbank.Subject;
import com.utunan.service.questionbank.QuestionIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("subjectService")
public class QuestionIndexServiceImpl implements QuestionIndexService {

	@Autowired
	private QuestionIndexMapper questionIndexMapper;

	/**
	 * @author  孙程程
	 * @description 查找所有科目
	 * @date  15:41 2018/12/4
	 * @return  java.util.List<com.utunan.pojo.base.questionbank.Subject>
	 */
	@Override
	public List<Subject> listSubject(){
		return this.questionIndexMapper.listSubject();
	}

	/**
	 * @author  孙程程
	 * @description 查找某科目下所有问题数量
	 * @date  15:41 2018/12/4
	 * @param  subjectId
	 * @return  java.lang.Long
	 */
	@Override
	public Long countQuestionBySubject( Long subjectId){
		return this.questionIndexMapper.countQuestionBySubject(subjectId);
	}

	/**
	 * @author  孙程程
	 * @description 查找某科目下某用户已做题目数量
	 * @date  15:41 2018/12/4
	 * @param  subjectId, userId
	 * @return  java.lang.Long
	 */
	@Override
	public Long countResolveQuestionBySubject(Long subjectId, Long userId){
		return this.questionIndexMapper.countResolveQuestionBySubject(subjectId,userId);
	}

	/**
	 * @author  孙程程
	 * @description 查找某科目下所有问题数量
	 * @date  15:20 2018/12/5
	 * @param  subjectName
	 * @return  java.util.List<com.utunan.pojo.base.questionbank.Question>
	 */
	@Override
	public List<Question> listQuestionBySubject(String subjectName, int pageNum, int pageSize){
		PageHelper.startPage(pageNum,pageSize);
		return this.questionIndexMapper.listQuestionBySubject(subjectName);
	}

	/**
	 * @author  孙程程
	 * @description 查找科目名称
	 * @date  15:48 2018/12/5
	 * @param  subjectName
	 * @return  java.lang.String
	 */
	@Override
	public Long findSubjectIdByName(String subjectName){
		return this.questionIndexMapper.findSubjectIdByName(subjectName);
	}

	/**
	 * @author  孙程程
	 * @description 搜索题目
	 * @date  16:11 2018/12/3
	 * @param  keyWords, pageNum, pageSize
	 * @return  java.util.List<com.utunan.pojo.base.questionbank.Question>
	 */
	@Override
	public List<Question> selectQuestionBySearchValue(List<String> keyWords, int pageNum, int pageSize){
		String keyWord="";
		for(int i=0; i<keyWords.size(); i++){
			keyWord += keyWords.get(i);
			if (i != (keyWords.size()-1)){
				keyWord += "|";
			}
		}
		PageHelper.startPage(pageNum,pageSize);
		//题目列表
		List<Question> questionList=this.questionIndexMapper.selectQuestionBySearchValue(keyWord);
		condenseQuestion(questionList);
		for(int i=0; i<questionList.size(); i++){
			Question q=questionList.get(i);
			for(int j=0; j<keyWords.size(); j++){
				if(keyWords.get(j)!="."){
					q.setChapterName(q.getChapterName().replaceAll(keyWords.get(j),"<span style='color:red'>"+keyWords.get(j)+"</span>"));
					q.setQuestionContent(q.getQuestionContent().replaceAll(keyWords.get(j),"<span style='color:red'>"+keyWords.get(j)+"</span>"));
				}
			}
		}
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
		return this.questionIndexMapper.countAllQuestion();
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
