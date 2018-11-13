package com.utunan.pojo.school;

public class Research {

    //研究方向Id
    private Long researchId;
    //专业方向Id
    private Long majorId;
    //研究方向名称
    private String researchName;
    //研究方向代码
    private  String researchCode;

    public Long getResearchId() {
        return researchId;
    }

    public void setResearchId(Long researchId) {
        this.researchId = researchId;
    }

    public Long getMajorId() {
        return majorId;
    }

    public void setMajorId(Long majorId) {
        this.majorId = majorId;
    }

    public String getResearchName() {
        return researchName;
    }

    public void setResearchName(String researchName) {
        this.researchName = researchName;
    }

    public String getResearchCode() {
        return researchCode;
    }

    public void setResearchCode(String researchCode) {
        this.researchCode = researchCode;
    }

    @Override
    public String toString() {
        return "Research{" +
                "researchId=" + researchId +
                ", majorId=" + majorId +
                ", researchName='" + researchName + '\'' +
                ", researchCode='" + researchCode + '\'' +
                '}';
    }
}
