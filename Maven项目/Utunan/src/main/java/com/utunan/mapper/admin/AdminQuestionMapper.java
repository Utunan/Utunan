package com.utunan.mapper.admin;

import com.utunan.pojo.base.questionbank.Question;

import java.util.List;

public interface AdminQuestionMapper {

    //数据结构
    List<Question> selectAllDS();
    //C语言
    List<Question> selectAllC();
    //网络原理
    List<Question> selectAllNetwork();
    //操作系统
    List<Question> selectAllOS();
    //组成原理
    List<Question> selectAllConstitute();
    //软件工程
    List<Question> selectAllSE();
    //根据关键字查询问题
    List<Question> selectQuestionByKeyword(String keyword);

}
