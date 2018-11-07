package com.utunan.pojo.school;

public class SchoolType {

    //学校类型Id
    private Integer schoolTypeId;
    //学校类型名称
    private String schoolTypeName;

    public Integer getSchoolTypeId() {
        return schoolTypeId;
    }

    public void setSchoolTypeId(Integer schoolTypeId) {
        this.schoolTypeId = schoolTypeId;
    }

    public String getSchoolTypeName() {
        return schoolTypeName;
    }

    public void setSchoolTypeName(String schoolTypeName) {
        this.schoolTypeName = schoolTypeName;
    }
    @Override
    public String toString() {
        return "SchoolType{" +
                "schoolTypeId=" + schoolTypeId +
                ", schoolTypeName='" + schoolTypeName + '\'' +
                '}';
    }
}
