package com.utunan.service.admin;

public interface QuestionDelService {
    //批量删除数据结构题目
    void delAllDsQuestion(Long[] b);



    //批量删除C语言题目
    void delAllCQuestion(Long[] b);

    //批量删除操作系统题目
    void delAllOsQuestion(Long[] b);

    //批量删除组成原理题目
    void delAllConstitute(Long[] b);

    //批量删除网络原理题目
    void delAllNetwork(Long[] b);

    //批量删除软件工程题目
    void delAllSeQuestion(Long[] b);
}
