package com.utunan.pojo.base.school;

import com.utunan.pojo.base.user.User;

import java.util.List;

/**
 * 研究方向实体类
 */
public class Direction {
    //研究方向编号
    private  Long directionId;
    //学校名称
    private  String schoolName;
    //所属学院
    private  String collegeName;
    //专业名称
    private String majorlName;
    //研究方向名称
    private String directionName;
    //学位类型
    private String degreeType;
    //政治
    private String politics;
    //英语
    private String english;
    //数学
    private String math;
    //专业基础课
    private String majorBasics;
    //院校浏览次数
    private Long viewCount;

    public Long getViewCount() {
        return viewCount;
    }

    public void setViewCount(Long viewCount) {
        this.viewCount = viewCount;
    }

    private List<User> users;

    public List<User> getUsers() {
        return users;
    }


    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Long getDirectionId() {
        return directionId;
    }

    public void setDirectionId(Long directionId) {
        this.directionId = directionId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getMajorlName() {
        return majorlName;
    }

    public void setMajorlName(String majorlName) {
        this.majorlName = majorlName;
    }

    public String getDirectionName() {
        return directionName;
    }

    public void setDirectionName(String directionName) {
        this.directionName = directionName;
    }

    public String getDegreeType() {
        return degreeType;
    }

    public void setDegreeType(String degreeType) {
        this.degreeType = degreeType;
    }

    public String getPolitics() {
        return politics;
    }

    public void setPolitics(String politics) {
        this.politics = politics;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getMath() {
        return math;
    }

    public void setMath(String math) {
        this.math = math;
    }

    public String getMajorBasics() {
        return majorBasics;
    }

    public void setMajorBasics(String majorBasics) {
        this.majorBasics = majorBasics;
    }

    @Override
    public String toString() {
        return "Direction{" +
                "directionId=" + directionId +
                ", schoolName='" + schoolName + '\'' +
                ", collegeName='" + collegeName + '\'' +
                ", majorlName='" + majorlName + '\'' +
                ", directionName='" + directionName + '\'' +
                ", degreeType='" + degreeType + '\'' +
                ", politics='" + politics + '\'' +
                ", english='" + english + '\'' +
                ", math='" + math + '\'' +
                ", majorBasics='" + majorBasics + '\'' +
                ", viewCount=" + viewCount +
                ", users=" + users +
                '}';
    }
}
