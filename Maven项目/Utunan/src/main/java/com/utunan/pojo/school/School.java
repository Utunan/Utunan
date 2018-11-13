package com.utunan.pojo.school;

/**
 * Univ:大学
 */
public class School{
    //大学编号
    private Long schoolId;
    //大学类型
    private String schoolType;
    //大学代码/编号
    private String schoolCode;
    //大学名称
    private String schoolName;
    //大学所在地
    private String schoolArea;


    public Long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolType() {
        return schoolType;
    }

    public void setSchoolType(String schoolType) {
        this.schoolType = schoolType;
    }

    public String getSchoolCode() {
        return schoolCode;
    }

    public void setSchoolCode(String schoolCode) {
        this.schoolCode = schoolCode;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolLarea() {
        return schoolArea;
    }

    public void setSchoolLarea(String schoolLarea) {
        this.schoolArea = schoolLarea;
    }

    @Override
    public String toString() {
        return "School{" +
                "schoolId=" + schoolId +
                ", schoolTypeId=" + schoolType +
                ", schoolCode='" + schoolCode + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", schoolLarea='" + schoolArea + '\'' +
                '}';
    }
}
