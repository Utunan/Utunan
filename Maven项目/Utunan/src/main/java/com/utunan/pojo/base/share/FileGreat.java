package com.utunan.pojo.base.share;

/**
 * @author 孙程程
 * @description: TODO
 * @date 2018/12/19 8:22
 */
public class FileGreat {
	private Long fileGreatId;
	private Long fileId;
	private Long UserId;
	private Long operate;

	public Long getFileGreatId() {
		return fileGreatId;
	}

	public void setFileGreatId(Long fileGreatId) {
		this.fileGreatId = fileGreatId;
	}

	public Long getFileId() {
		return fileId;
	}

	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}

	public Long getUserId() {
		return UserId;
	}

	public void setUserId(Long userId) {
		UserId = userId;
	}

	public Long getOperate() {
		return operate;
	}

	public void setOperate(Long operate) {
		this.operate = operate;
	}

	@Override
	public String toString() {
		return "FileGreat{" +
				"fileGreatId=" + fileGreatId +
				", fileId=" + fileId +
				", UserId=" + UserId +
				", operate=" + operate +
				'}';
	}
}
