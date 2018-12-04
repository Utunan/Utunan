package com.utunan.pojo.inherit.questionbank;

import com.utunan.pojo.base.questionbank.Subject;

/**
 * @author 孙程程
 * @description: TODO
 * @date 2018/12/4 15:11
 */
public class SubjectCount {
	private Subject subject;
	private Long allQuestionNumber;
	private Long resolveQuestionNumber;

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Long getAllQuestionNumber() {
		return allQuestionNumber;
	}

	public void setAllQuestionNumber(Long allQuestionNumber) {
		this.allQuestionNumber = allQuestionNumber;
	}

	public Long getResolveQuestionNumber() {
		return resolveQuestionNumber;
	}

	public void setResolveQuestionNumber(Long resolveQuestionNumber) {
		this.resolveQuestionNumber = resolveQuestionNumber;
	}

	@Override
	public String toString() {
		return "SubjectCount{" +
				"subject=" + subject +
				", allQuestionNumber=" + allQuestionNumber +
				", resolveQuestionNumber=" + resolveQuestionNumber +
				'}';
	}
}
