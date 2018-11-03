package com.utunan.pojo;

/**
 * 初试考试科目-MajorTextMapper
 */
public class MajorText {
	//初试考试科目ID
	private Long majorTextId;
	//科目名称
	private String majorTextName;
	//科目代码
	private Long majorTextCode;

	public Long getMajorTextId() {
		return majorTextId;
	}

	public void setMajorTextId(Long majorTextId) {
		this.majorTextId = majorTextId;
	}

	public String getMajorTextName() {
		return majorTextName;
	}

	public void setMajorTextName(String majorTextName) {
		this.majorTextName = majorTextName;
	}

	public Long getMajorTextCode() {
		return majorTextCode;
	}

	public void setMajorTextCode(Long majorTextCode) {
		this.majorTextCode = majorTextCode;
	}

	@Override
	public String toString() {
		return "MajorTextMapper{" +
				"majorTextId=" + majorTextId +
				", majorTextName='" + majorTextName + '\'' +
				", majorTextCode=" + majorTextCode +
				'}';
	}
}
