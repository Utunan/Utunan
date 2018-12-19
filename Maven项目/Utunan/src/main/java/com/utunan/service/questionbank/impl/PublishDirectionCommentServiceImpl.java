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

    @Override
    public Long addDCPraiseCount(Long directionCommentId) {
        return this.publishDirectionCommentMapper.addDCPraiseCount(directionCommentId);
    }
    @Override
    public Long delDCPraiseCount(Long directionCommentId) {
        return this.publishDirectionCommentMapper.delDCPraiseCount(directionCommentId);
    }
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
