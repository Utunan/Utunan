package com.utunan.pojo.school;

/**
 * 专业表-Major
 */
public class Major {
	//专业ID
	private Long majorId;
	//学校ID
	private Long schoolId;
	//专业名称
	private String schoolName;
	//所属学院
	private String college;
	//学位类型
	private String degreeType;
	//初试考试科目
	private String majorTextId;
	//数学类型（数一、数二、数三）
	private String mathTypeId;
	//英语类型（英一、英二）
	private String englishType;

	public Long getMajorId() {
		return majorId;
	}

	public void setMajorId(Long majorId) {
		this.majorId = majorId;
	}

	public Long getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Long schoolId) {
		this.schoolId = schoolId;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getDegreeType() {
		return degreeType;
	}

	public void setDegreeType(String degreeType) {
		this.degreeType = degreeType;
	}

	public String getMajorTextId() {
		return majorTextId;
	}

	public void setMajorTextId(String majorTextId) {
		this.majorTextId = majorTextId;
	}

	public String getMathTypeId() {
		return mathTypeId;
	}

	public void setMathTypeId(String mathTypeId) {
		this.mathTypeId = mathTypeId;
	}

	public String getEnglishType() {
		return englishType;
	}

	public void setEnglishType(String englishType) {
		this.englishType = englishType;
	}

	@Override
	public String toString() {
		return "Major{" +
				"majorId=" + majorId +
				", schoolId=" + schoolId +
				", schoolName='" + schoolName + '\'' +
				", college='" + college + '\'' +
				", degreeType='" + degreeType + '\'' +
				", majorTextId='" + majorTextId + '\'' +
				", mathTypeId='" + mathTypeId + '\'' +
				", englishType='" + englishType + '\'' +
				'}';
	}
}
