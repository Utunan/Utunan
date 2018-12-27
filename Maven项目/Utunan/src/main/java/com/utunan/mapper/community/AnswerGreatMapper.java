package com.utunan.mapper.community;

import com.utunan.pojo.base.community.AnswerGreat;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 张正扬
 * @description: TODO
 * @date 2018/12/8 17:19
 */
@Mapper
@Repository
public interface AnswerGreatMapper {
    //获取AnswerGreat表中信息
    AnswerGreat getAnswerGreat(@Param("answerId") Long answerId, @Param("userId") Long userId);

    //添加AnswerGreat表中信息
    void addAnswerGreat(@Param("answerId") Long answerId, @Param("userId") Long userId);

    //删除AnswerGreat表中信息
    void delAnswerGreat(@Param("answerId") Long answerId, @Param("userId") Long userId);

    //获取用户在评论的点赞列表
    List<Long> getAGList(@Param("userId") Long userId);
}
