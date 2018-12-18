package com.utunan.mapper.admin;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface QuestionDelMapper {
    //批量删除数据结构题目
    void delAllDsQuestion(@Param("b") Long[] b);

    //批量删除C语言题目
    void delAllCQuestion(@Param("b") Long[] b);

    //批量删除操作系统题目
    void delAllOsQuestion(@Param("b") Long[] b);

    //批量删除组成原理题目
    void delAllConstitute(@Param("b") Long[] b);

    //批量删除网络原理题目
    void delAllNetwork(@Param("b") Long[] b);

    //批量删除软件工程题目
    void delAllSeQuestion(@Param("b") Long[] b);
}
