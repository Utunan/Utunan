package com.utunan.pojo.community;

/**
 * 板块-Tag
 */
public class Tag {
	//标签ID
	private Long plateId;
	//标签名称
	private String plateName;

	public Long getPlateId() {
		return plateId;
	}

	public void setPlateId(Long plateId) {
		this.plateId = plateId;
	}

	public String getPlateName() {
		return plateName;
	}

	public void setPlateName(String plateName) {
		this.plateName = plateName;
	}

	@Override
	public String toString() {
		return "Tag{" +
				"plateId=" + plateId +
				", plateName='" + plateName + '\'' +
				'}';
	}
}
