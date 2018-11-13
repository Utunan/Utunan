package com.utunan.pojo.user;

import java.util.Date;

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
    private int userIdentity;
    //注册时间
    private String registerTime;
    //最近登陆时间
    private String loginTime;
    //用户头像
    private String userHeadImg;
    //用户昵称
    private String userNickName;
    //用户目前所在学校
    private String userSchool;
    //用户梦想院校
    private String dreamSchool;

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

    public int getUserIdentity() {
        return userIdentity;
    }

    public void setUserIdentity(int userIdentity) {
        this.userIdentity = userIdentity;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
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

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userEmail='" + userEmail + '\'' +
                ", userTelephone='" + userTelephone + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userIdentity=" + userIdentity +
                ", registerTime='" + registerTime + '\'' +
                ", loginTime='" + loginTime + '\'' +
                ", userHeadImg='" + userHeadImg + '\'' +
                ", userNickName='" + userNickName + '\'' +
                ", userSchool='" + userSchool + '\'' +
                ", dreamSchool='" + dreamSchool + '\'' +
                '}';
    }
}
