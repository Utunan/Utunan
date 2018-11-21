package com.utunan.pojo.community;

import java.util.List;

/**
 * 板块-Tag
 */
public class Tag {
	//标签ID
	private Long tagId;
	//标签名称
	private String tagName;
	//quizTag
	private List<QuizTag> quizTag;

	public List<QuizTag> getQuizTag() {
		return quizTag;
	}

	public void setQuizTag(List<QuizTag> quizTag) {
		this.quizTag = quizTag;
	}

	public Long getTagId() {
		return tagId;
	}

	public void setTagId(Long tagId) {
		this.tagId = tagId;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	@Override
	public String toString() {
		return "Tag{" +
				"tagId=" + tagId +
				", tagName='" + tagName + '\'' +
				'}';
	}
}
