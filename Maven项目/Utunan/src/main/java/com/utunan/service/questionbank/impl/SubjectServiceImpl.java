package com.utunan.service.questionbank.impl;

import com.utunan.mapper.questionbank.QuestionSearchMapper;
import com.utunan.pojo.base.questionbank.Subject;
import com.utunan.service.questionbank.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("subjectService")
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private QuestionSearchMapper questionSearchMapper;

	/**
	 * @author  孙程程
	 * @description 查找所有科目
	 * @date  15:41 2018/12/4
	 * @return  java.util.List<com.utunan.pojo.base.questionbank.Subject>
	 */
	@Override
	public List<Subject> listSubject(){
		return this.questionSearchMapper.listSubject();
	}

	/**
	 * @author  孙程程
	 * @description 查找某科目下所示问题数量
	 * @date  15:41 2018/12/4
	 * @param  subjectId
	 * @return  java.lang.Long
	 */
	@Override
	public Long countQuestionBySubject( Long subjectId){
		return this.questionSearchMapper.countQuestionBySubject(subjectId);
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
		return this.questionSearchMapper.countResolveQuestionBySubject(subjectId,userId);
	}

}
