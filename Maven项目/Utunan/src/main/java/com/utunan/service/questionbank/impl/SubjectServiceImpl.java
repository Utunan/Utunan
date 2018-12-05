package com.utunan.service.questionbank.impl;

import com.github.pagehelper.PageHelper;
import com.utunan.mapper.questionbank.QuestionSearchMapper;
import com.utunan.mapper.questionbank.SubjectMapper;
import com.utunan.pojo.base.questionbank.Question;
import com.utunan.pojo.base.questionbank.Subject;
import com.utunan.service.questionbank.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("subjectService")
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private SubjectMapper subjectMapper;

	/**
	 * @author  孙程程
	 * @description 查找所有科目
	 * @date  15:41 2018/12/4
	 * @return  java.util.List<com.utunan.pojo.base.questionbank.Subject>
	 */
	@Override
	public List<Subject> listSubject(){
		return this.subjectMapper.listSubject();
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
		return this.subjectMapper.countQuestionBySubject(subjectId);
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
		return this.subjectMapper.countResolveQuestionBySubject(subjectId,userId);
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
		return this.subjectMapper.listQuestionBySubject(subjectName);
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
		return this.subjectMapper.findSubjectIdByName(subjectName);
	}
}
