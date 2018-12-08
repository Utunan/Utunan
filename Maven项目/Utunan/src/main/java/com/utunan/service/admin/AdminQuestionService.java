package com.utunan.service.admin;

import com.utunan.pojo.base.questionbank.Question;

import java.util.List;

public interface AdminQuestionService {
    //数据结构
    List<Question> getAllDS(int pageNum,int pageSize);
    //C语言
    List<Question> getAllC(int pageNum,int pageSize);
    //网络原理
    List<Question> getAllNetwork(int pageNum,int pageSize);
    //操作系统
    List<Question> getAllOS(int pageNum,int pageSize);
    //组成原理
    List<Question> getAllConstitute(int pageNum,int pageSize);
    //软件工程
    List<Question> getAllSE(int pageNum,int pageSize);
    //根据关键字查询问题
    List<Question> getQuestionByKeyword(String keyword);
}
