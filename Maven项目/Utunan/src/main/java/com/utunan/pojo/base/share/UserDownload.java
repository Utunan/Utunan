package com.utunan.pojo.base.share;

/**
 * @author 孙程程
 * @description: TODO
 * @date 2018/12/18 15:40
 */
public class UserDownload {
	private Long userDownloadId;
	private Long userId;
	private Long fileId;

	public Long getUserDownloadId() {
		return userDownloadId;
	}

	public void setUserDownloadId(Long userDownloadId) {
		this.userDownloadId = userDownloadId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getFileId() {
		return fileId;
	}

	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}

	@Override
	public String toString() {
		return "UserDownload{" +
				"userDownloadId=" + userDownloadId +
				", userId=" + userId +
				", fileId=" + fileId +
				'}';
	}
}
