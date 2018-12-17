package com.utunan.mapper.admin;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdminDelMapper {
    //批量删除用户
    void delAllMember(@Param("a") Long[] a);

    //批量删除院系评论
    void delAllSchoolComment(@Param("b") Long[] b);
}
