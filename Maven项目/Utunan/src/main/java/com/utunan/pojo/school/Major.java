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
	private String majorName;
	//所属学院
	private String college;
	//学位类型
	private String degreeType;
	//初试考试科目
	private String majorText;
	//数学类型（数一、数二、数三）
	private String mathType;
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

	public String getMajorName() {	return majorName; }

	public void setMajorName(String majorName) {
		this.majorName = majorName;
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

	public String getMajorText() {
		return majorText;
	}

	public void setMajorText(String majorText) {
		this.majorText = majorText;
	}

	public String getMathType() {
		return mathType;
	}

	public void setMathType(String mathType) {
		this.mathType = mathType;
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
				", majorName='" + majorName + '\'' +
				", college='" + college + '\'' +
				", degreeType='" + degreeType + '\'' +
				", englishType='" + englishType + '\'' +
				'}';
	}
}
