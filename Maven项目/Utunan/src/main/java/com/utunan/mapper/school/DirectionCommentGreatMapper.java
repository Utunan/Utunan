package com.utunan.mapper.school;

import com.utunan.pojo.base.school.DirectionCommentGreat;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 王碧云
 * @description: TODO
 * @date 2018/12/19/019 9:28
 */
@Mapper
@Repository
public interface DirectionCommentGreatMapper {
    /*查询某用户是否在某评论点赞*/
    DirectionCommentGreat findDCGreat(@Param("directionCommentId") Long directionCommentId, @Param("userId") Long userId);
    /*添加用户点赞记录*/
    void insertDCGreat(@Param("directionCommentId") Long directionCommentId, @Param("userId") Long userId);
    /*删除用户点赞记录*/
    void deleteDCGreat(@Param("directionCommentId") Long directionCommentId, @Param("userId") Long userId);
    /*查询该用户在某院校下的点赞列表*/
    List<Long> findfindDCGreatList(@Param("userId") Long userId);
}
