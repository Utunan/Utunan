package com.utunan.pojo.base.questionbank;

import java.util.Date;

/**
 * @author 孙程程
 * @description: TODO
 * @date 2018/11/28 9:48
 */
public class Note {
	//笔记ID
	private Long noteId;
	//题目ID
	private Long questionId;
	//用户ID
	private Long userId;
	//笔记内容
	private String noteContent;
	//笔记发表时间
	private Date noteTime;
	//笔记点赞数量
	private Long notePraiseCount;
	//上级笔记ID
	private Long replyNoteId;

	public Long getNoteId() {
		return noteId;
	}

	public void setNoteId(Long noteId) {
		this.noteId = noteId;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getNoteContent() {
		return noteContent;
	}

	public void setNoteContent(String noteContent) {
		this.noteContent = noteContent;
	}

	public Date getNoteTime() {
		return noteTime;
	}

	public void setNoteTime(Date noteTime) {
		this.noteTime = noteTime;
	}

	public Long getNotePraiseCount() {
		return notePraiseCount;
	}

	public void setNotePraiseCount(Long notePraiseCount) {
		this.notePraiseCount = notePraiseCount;
	}

	public Long getReplyNoteId() {
		return replyNoteId;
	}

	public void setReplyNoteId(Long replyNoteId) {
		this.replyNoteId = replyNoteId;
	}

	@Override
	public String toString() {
		return "Note{" +
				"noteId=" + noteId +
				", questionId=" + questionId +
				", userId=" + userId +
				", noteContent='" + noteContent + '\'' +
				", noteTime=" + noteTime +
				", notePraiseCount=" + notePraiseCount +
				", replyNoteId=" + replyNoteId +
				'}';
	}
}
