package com.utunan.service.school.impl;

import com.utunan.mapper.school.DirectionCommentGreatMapper;
import com.utunan.pojo.base.school.DirectionCommentGreat;
import com.utunan.service.school.DirectionCommentGreatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 王碧云
 * @description: TODO
 * @date 2018/12/19/019 9:47
 */
@Service("directionCommentGreatService")
public class DirectionCommentGreatServiceImpl implements DirectionCommentGreatService {
    @Autowired
    private DirectionCommentGreatMapper directionCommentGreatMapper;

    @Override
    public DirectionCommentGreat findDCGreat(Long directionCommentId, Long userId) {
        return this.directionCommentGreatMapper.findDCGreat(directionCommentId,userId );
    }

    @Override
    public void insertDCGreat(Long directionCommentId, Long userId) {
        this.directionCommentGreatMapper.insertDCGreat(directionCommentId, userId);
    }

    @Override
    public void deleteDCGreat(Long directionCommentId, Long userId) {
        this.directionCommentGreatMapper.deleteDCGreat(directionCommentId, userId);
    }

    @Override
    public List<Long> findfindDCGreatList(Long userId) {
        return this.directionCommentGreatMapper.findfindDCGreatList(userId);
    }
}
