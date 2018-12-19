package com.utunan.mapper.questionbank;

import com.utunan.pojo.base.questionbank.DirectionCommentGreat;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

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
}
