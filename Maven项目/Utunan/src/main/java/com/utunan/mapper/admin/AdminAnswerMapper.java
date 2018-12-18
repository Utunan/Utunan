package com.utunan.mapper.admin;

import com.utunan.pojo.base.community.Answer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminAnswerMapper {
    //获取所有回答评论
    List<Answer> getAllAnswer();
}
