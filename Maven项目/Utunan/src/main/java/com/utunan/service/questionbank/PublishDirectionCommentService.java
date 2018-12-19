package com.utunan.service.questionbank;

import com.utunan.pojo.inherit.questionbank.PublishDirectionComment;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * @author 王碧云
 * @description: TODO
 * @date 2018/12/5/005 17:29
 */
public interface PublishDirectionCommentService {
    /*王碧云 增加点赞数量*/
    Long addDCPraiseCount(Long directionCommentId);
    /*王碧云 减少点赞数量*/
    Long delDCPraiseCount(Long directionCommentId);
    /*插入评论*/
    void insertDirectionComment(Long userId,Long directionId, String directionCommentContent);
    /*删除评论*/
    void deleteDirectionComment(Long directionCommentId);
}
