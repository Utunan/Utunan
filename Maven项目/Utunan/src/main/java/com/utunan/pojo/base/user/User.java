package com.utunan.pojo.base.user;

import com.utunan.pojo.base.community.Quiz;

import java.util.Date;
import java.util.Dictionary;
import java.util.List;

/**
 * User:用户
 */
public class User {

    //用户id
    private Long userId;
    //用户邮箱
    private String userEmail;
    //用户手机
    private String userTelephone;
    //用户密码
    private String userPassword;
    //用户权限
    private String userIdentity;
    //考研年份
    private String examTime;
    //注册时间
    private Date registerTime;
    //用户头像
    private String userHeadImg;
    //用户昵称
    private String userNickName;
    //用户目前所在学校
    private String userSchool;
    //用户梦想院校
    private String dreamSchool;
    //用户积分
    private Integer userIntegral;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserTelephone() {
        return userTelephone;
    }

    public void setUserTelephone(String userTelephone) {
        this.userTelephone = userTelephone;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserIdentity() {
        return userIdentity;
    }

    public void setUserIdentity(String userIdentity) {
        this.userIdentity = userIdentity;
    }

    public String getExamTime() {
        return examTime;
    }

    public void setExamTime(String examTime) {
        this.examTime = examTime;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public String getUserHeadImg() {
        return userHeadImg;
    }

    public void setUserHeadImg(String userHeadImg) {
        this.userHeadImg = userHeadImg;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getUserSchool() {
        return userSchool;
    }

    public void setUserSchool(String userSchool) {
        this.userSchool = userSchool;
    }

    public String getDreamSchool() {
        return dreamSchool;
    }

    public void setDreamSchool(String dreamSchool) {
        this.dreamSchool = dreamSchool;
    }

    public Integer getUserIntegral() {
        return userIntegral;
    }

    public void setUserIntegral(Integer userIntegral) {
        this.userIntegral = userIntegral;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userEmail='" + userEmail + '\'' +
                ", userTelephone='" + userTelephone + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userIdentity=" + userIdentity +
                ", examTime='" + examTime + '\'' +
                ", registerTime=" + registerTime +
                ", userHeadImg='" + userHeadImg + '\'' +
                ", userNickName='" + userNickName + '\'' +
                ", userSchool='" + userSchool + '\'' +
                ", dreamSchool='" + dreamSchool + '\'' +
                ", userIntegral=" + userIntegral +
                '}';
    }
}
