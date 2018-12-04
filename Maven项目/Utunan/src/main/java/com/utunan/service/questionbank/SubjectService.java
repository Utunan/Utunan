package com.utunan.service.questionbank;

import com.utunan.pojo.base.questionbank.Subject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SubjectService {
	/**
	 * @author  孙程程
	 * @description 查找所有科目
	 * @date  15:41 2018/12/4
	 * @return  java.util.List<com.utunan.pojo.base.questionbank.Subject>
	 */
	List<Subject> listSubject();

	/**
	 * @author  孙程程
	 * @description 查找某科目下所示问题数量
	 * @date  15:41 2018/12/4
	 * @param  subjectId
	 * @return  java.lang.Long
	 */
	Long countQuestionBySubject( Long subjectId);

	/**
	 * @author  孙程程
	 * @description 查找某科目下某用户已做题目数量
	 * @date  15:41 2018/12/4
	 * @param  subjectId, userId
	 * @return  java.lang.Long
	 */
	Long countResolveQuestionBySubject(Long subjectId, Long userId);

}
