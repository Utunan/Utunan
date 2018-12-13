package com.utunan.mapper.admin;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DelMemberMapper {
    //批量删除用户
    void delAllMember(@Param("a") Long[] a);
}
