package com.utunan.pojo;

/**
 * Univ:大学
 */
public class School{
    //大学编号
    private int schoolId;
    //大学类型
    private String schoolTypeId;
    //大学名称
    private String schoolName;
    //大学代码/编号
    private String schoolCode;
    //大学所在地
    private String schoolLarea;


    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolTypeId() {
        return schoolTypeId;
    }

    public void setSchoolTypeId(String schoolTypeId) {
        this.schoolTypeId = schoolTypeId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolCode() {
        return schoolCode;
    }

    public void setSchoolCode(String schoolCode) {
        this.schoolCode = schoolCode;
    }

    public String getSchoolLarea() {
        return schoolLarea;
    }

    public void setSchoolLarea(String schoolLarea) {
        this.schoolLarea = schoolLarea;
    }

    @Override
    public String toString() {
        return "School{" +
                "schoolId=" + schoolId +
                ", schoolTypeId='" + schoolTypeId + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", schoolCode='" + schoolCode + '\'' +
                ", schoolLarea='" + schoolLarea + '\'' +
                '}';
    }
}
