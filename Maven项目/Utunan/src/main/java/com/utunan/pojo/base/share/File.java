package com.utunan.pojo.base.share;

import com.utunan.pojo.base.user.User;

import java.util.Date;

/**
 * @author 孙程程
 * @description: TODO
 * @date 2018/12/10 16:36
 */
public class File {
	private Long fileId;
	private Long userId;
	private Date fileTime;
	private Long downloadNumber;
	private String fileTitle;
	private String fileUrl;
	private String fileType;
	private String fileSchool;
	private Long fileCredit;
	private Long suffixId;
	private Long isExamine;
	private User user;
	private Suffix suffix;
	private String fileDiscription;
	private Long upNumber;
	private Long downNumber;

	public Long getFileId() {
		return fileId;
	}

	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getFileTime() {
		return fileTime;
	}

	public void setFileTime(Date fileTime) {
		this.fileTime = fileTime;
	}

	public Long getDownloadNumber() {
		return downloadNumber;
	}

	public void setDownloadNumber(Long downloadNumber) {
		this.downloadNumber = downloadNumber;
	}

	public String getFileTitle() {
		return fileTitle;
	}

	public void setFileTitle(String fileTitle) {
		this.fileTitle = fileTitle;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getFileSchool() {
		return fileSchool;
	}

	public void setFileSchool(String fileSchool) {
		this.fileSchool = fileSchool;
	}

	public Long getFileCredit() {
		return fileCredit;
	}

	public void setFileCredit(Long fileCredit) {
		this.fileCredit = fileCredit;
	}

	public Long getSuffixId() {
		return suffixId;
	}

	public void setSuffixId(Long suffixId) {
		this.suffixId = suffixId;
	}

	public Long getIsExamine() {
		return isExamine;
	}

	public void setIsExamine(Long isExamine) {
		this.isExamine = isExamine;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Suffix getSuffix() {
		return suffix;
	}

	public void setSuffix(Suffix suffix) {
		this.suffix = suffix;
	}

	public String getFileDiscription() {
		return fileDiscription;
	}

	public void setFileDiscription(String fileDiscription) {
		this.fileDiscription = fileDiscription;
	}

	public Long getUpNumber() {
		return upNumber;
	}

	public void setUpNumber(Long upNumber) {
		this.upNumber = upNumber;
	}

	public Long getDownNumber() {
		return downNumber;
	}

	public void setDownNumber(Long downNumber) {
		this.downNumber = downNumber;
	}

	@Override
	public String toString() {
		return "File{" +
				"fileId=" + fileId +
				", userId=" + userId +
				", fileTime=" + fileTime +
				", downloadNumber=" + downloadNumber +
				", fileTitle='" + fileTitle + '\'' +
				", fileUrl='" + fileUrl + '\'' +
				", fileType='" + fileType + '\'' +
				", fileSchool='" + fileSchool + '\'' +
				", fileCredit=" + fileCredit +
				", suffixId=" + suffixId +
				", isExamine=" + isExamine +
				", user=" + user +
				", suffix=" + suffix +
				", fileDiscription='" + fileDiscription + '\'' +
				", upNumber=" + upNumber +
				", downNumber=" + downNumber +
				'}';
	}
}
