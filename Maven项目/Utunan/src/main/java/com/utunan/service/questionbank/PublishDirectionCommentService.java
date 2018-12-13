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
    /*王碧云 修改点赞数量*/
    Long updateDirectionCommentPraiseCount(Long directionCommentId);
    /*插入评论*/
    void insertDirectionComment(Long userId,Long directionId, String directionCommentContent);
    /*删除评论*/
    void deleteDirectionComment(Long directionCommentId);
}
