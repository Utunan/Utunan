package com.utunan.mapper.school;

import com.utunan.pojo.inherit.school.PublishDirectionComment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * @author 王碧云
 * @description: TODO
 * @date 2018/12/5/005 17:25
 */
@Mapper
@Repository
public interface PublishDirectionCommentMapper {
    /*查找评论*/
    PublishDirectionComment findPDC(@Param("directionCommentId") Long directionCommentId);
    /*王碧云 增加点赞数量*/
    Long addDCPraiseCount(@Param("directionCommentId") Long directionCommentId);
    /*王碧云 减少点赞数量*/
    Long delDCPraiseCount(@Param("directionCommentId") Long directionCommentId);
    /*王碧云 插入评论*/
    void insertDirectionComment(@Param("userId") Long userId, @Param("directionId") Long directionId,@Param("directionCommentContent") String directionCommentContent,@Param("directionCommentTime") Date directionCommentTime,@Param("directionCommentPraiseCount") Long directionCommentPraiseCount);
    /*删除评论*/
    void deleteDirectionComment(@Param("directionCommentId") Long directionCommentId);
}
