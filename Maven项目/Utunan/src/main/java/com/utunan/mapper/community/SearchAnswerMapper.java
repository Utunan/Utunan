package com.utunan.mapper.community;

import com.utunan.pojo.base.community.Answer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface SearchAnswerMapper {
    //根据搜索条件返回评论列表
    List<Answer> findAnswerListBySearch(@Param("searchValue") String searchValue);
}
