package com.utunan.service.questionbank;

import com.utunan.pojo.base.questionbank.Question;
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
	 * @description 查找某科目下所有问题数量
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

	/**
	 * @author  孙程程
	 * @description 查找某科目下所有问题
	 * @date  15:20 2018/12/5
	 * @param  subjectName
	 * @return  java.util.List<com.utunan.pojo.base.questionbank.Question>
	 */
	List<Question> listQuestionBySubject(String subjectName, int pageNum, int pageSize);

	/**
	 * @author  孙程程
	 * @description 查找科目名称
	 * @date  15:48 2018/12/5
	 * @param  subjectName
	 * @return  java.lang.String
	 */
	Long findSubjectIdByName(String subjectName);
}
