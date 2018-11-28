package com.utunan.service.school.impl;

import com.utunan.mapper.school.DirectionMapper;
import com.utunan.pojo.school.Direction;
import com.utunan.service.school.DirectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 王碧云
 * @description: TODO
 * @date 2018/11/27/027 21:50
 */
@Service("directionService")
public class DirectionServiceImpl implements DirectionService {

    @Autowired
    private DirectionMapper directionMapper;

    @Override
    public List<Direction> findAllDirection() {
        return this.directionMapper.findAllDirection();
    }
}
