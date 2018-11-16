package com.utunan.pojo.questionbank;

/**
 * 章节表-chapter
 */
public class Chapter {
	//章节ID
	private Long chapterId;
	//章节名称
	private String chapterName;
	//科目ID
	private Long subjectId;

	public Long getChapterId() {
		return chapterId;
	}

	public void setChapterId(Long chapterId) {
		this.chapterId = chapterId;
	}

	public String getChapterName() {
		return chapterName;
	}

	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}

	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	@Override
	public String toString() {
		return "Chapter{" +
				"chapterId=" + chapterId +
				", chapterName='" + chapterName + '\'' +
				", subjectId=" + subjectId +
				'}';
	}
}
