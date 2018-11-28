package com.utunan.pojo.school;

import java.util.List;

/**
 * Univ:学校
 */
public class School{
    //学校编号
    private Long schoolId;
    //学校名称
    private String schoolName;
    //学校地区
    private String schoolProvince;
    //学校类型
    private String schoolType;
    //学校隶属的组织
    private String schoolSubjection;
    //与研究方向一对多
    private List<Direction> direction;

    public List<Direction> getDirection() {
        return direction;
    }

    public void setDirection(List<Direction> direction) {
        this.direction = direction;
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

    public String getSchoolProvince() {
        return schoolProvince;
    }

    public void setSchoolProvince(String schoolProvince) {
        this.schoolProvince = schoolProvince;
    }

    public String getSchoolType() {
        return schoolType;
    }

    public void setSchoolType(String schoolType) {
        this.schoolType = schoolType;
    }

    public String getSchoolSubjection() {
        return schoolSubjection;
    }

    public void setSchoolSubjection(String schoolSubjection) {
        this.schoolSubjection = schoolSubjection;
    }

    @Override
    public String toString() {
        return "School{" +
                "schoolId=" + schoolId +
                ", schoolName=" + schoolName +
                ", schoolProvince='" + schoolProvince + '\'' +
                ", schoolType='" + schoolType + '\'' +
                ", schoolSubjection='" + schoolSubjection + '\'' +
                '}';
    }

}
