package com.utunan.pojo.base.share;

/**
 * @author 孙程程
 * @description: TODO
 * @date 2018/12/10 16:37
 */
public class Suffix {
	private Long suffixId;
	private String suffixName;
	private String imgUrl;

	public Long getSuffixId() {
		return suffixId;
	}

	public void setSuffixId(Long suffixId) {
		this.suffixId = suffixId;
	}

	public String getSuffixName() {
		return suffixName;
	}

	public void setSuffixName(String suffixName) {
		this.suffixName = suffixName;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	@Override
	public String toString() {
		return "Suffix{" +
				"suffixId=" + suffixId +
				", suffixName='" + suffixName + '\'' +
				", imgUrl='" + imgUrl + '\'' +
				'}';
	}
}
