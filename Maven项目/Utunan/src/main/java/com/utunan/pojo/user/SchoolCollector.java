package com.utunan.pojo.user;

public class SchoolCollector {

    //院校信息收藏列表Id
    private Long schoolCollectorId;
    //用户Id
    private Long userId;
    //学校Id
    private Long schoolId;
    //专业Id
    private Long majorId;
    //研究方向Id
    private Long researchId;

    public Long getSchoolCollectorId() {
        return schoolCollectorId;
    }

    public void setSchoolCollectorId(Long schoolCollectorId) {
        this.schoolCollectorId = schoolCollectorId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }

    public Long getMajorId() {
        return majorId;
    }

    public void setMajorId(Long majorId) {
        this.majorId = majorId;
    }

    public Long getResearchId() {
        return researchId;
    }

    public void setResearchId(Long researchId) {
        this.researchId = researchId;
    }

    @Override
    public String toString() {
        return "SchoolCollector{" +
                "schoolCollectorId=" + schoolCollectorId +
                ", userId=" + userId +
                ", schoolId=" + schoolId +
                ", majorId=" + majorId +
                ", researchId=" + researchId +
                '}';
    }
}
