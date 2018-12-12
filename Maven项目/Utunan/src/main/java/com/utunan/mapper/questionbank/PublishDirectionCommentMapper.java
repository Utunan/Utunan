package com.utunan.mapper.questionbank;

import com.utunan.pojo.inherit.questionbank.PublishDirectionComment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

/**
 * @author 王碧云
 * @description: TODO
 * @date 2018/12/5/005 17:25
 */
@Mapper
@Repository
public interface PublishDirectionCommentMapper {
    /*王碧云 修改点赞数量*/
    Long updateDirectionCommentPraiseCount(@Param("directionCommentId") Long directionCommentId);
    /*王碧云 插入评论*/
    void directionCommentContent(@Param("userId") Long userId, @Param("directionId") Long directionId, String directionCommentContent, Date  directionCommentTime,Long directionCommentPraiseCount);
}
