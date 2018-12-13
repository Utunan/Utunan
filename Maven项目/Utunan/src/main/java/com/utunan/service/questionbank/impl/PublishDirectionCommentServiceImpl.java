package com.utunan.service.questionbank.impl;

import com.utunan.mapper.questionbank.PublishDirectionCommentMapper;
import com.utunan.pojo.inherit.questionbank.PublishDirectionComment;
import com.utunan.service.questionbank.PublishDirectionCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 王碧云
 * @description: TODO
 * @date 2018/12/5/005 17:31
 */
@Service("publishDirectionCommentService")
public class PublishDirectionCommentServiceImpl implements PublishDirectionCommentService {
    @Autowired
    private PublishDirectionCommentMapper publishDirectionCommentMapper;
    /*
     * @author  王碧云
     * @description 修改点赞的数量
     * @date  17:32 2018/12/5/005
     * @param  [directionCommentId]
     * @return  java.lang.Long
     */
    @Override
    public Long updateDirectionCommentPraiseCount(Long directionCommentId) {
        return this.publishDirectionCommentMapper.updateDirectionCommentPraiseCount(directionCommentId);
    }

    /*
     * @author  王碧云
     * @description 插入评论
     * @date  22:02 2018/12/12/012
     * @param  [userId, directionId, directionCommentContent, directionCommentTime, directionCommentPraiseCount]
     * @return  void
     */
    @Override
    public void insertDirectionComment(Long userId, Long directionId, String directionCommentContent) {
        Date time = new Date();
        Long directionCommentPraiseCount = Long.parseLong("0");
        this.publishDirectionCommentMapper.insertDirectionComment(userId, directionId, directionCommentContent, time, directionCommentPraiseCount);
    }

    @Override
    public void deleteDirectionComment(Long directionCommentId) {
        this.publishDirectionCommentMapper.deleteDirectionComment(directionCommentId);
    }
}
