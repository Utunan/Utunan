package com.utunan.pojo.base.questionbank;

import com.utunan.pojo.base.user.User;

public class Question {
    //题库列表ID
    private Long questionId;
    //章节ID
    private String chapterName;
    //录入人ID
    private User User;
    //题目类型
    private String questionType;
    //题干内容
    private String questionContent;
    //选项A
    private String optionA;
    //选项B
    private String optionB;
    //选项C
    private String optionC;
    //选项D
    private String optionD;
    //正确答案
    private String questionAnswer;
    //解析
    private String questionAnalyse;
    //录入时间
    private String questionEnterTime;


}
