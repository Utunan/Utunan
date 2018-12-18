package com.utunan.mapper.admin;

import org.apache.ibatis.annotations.Param;

public interface QADelMapper {
    //批量删除提问
    void delAllQuiz(@Param("b") Long[] b);

    //批量删除回答评论
    void delAllAnswer(@Param("b") Long[] b);
}
