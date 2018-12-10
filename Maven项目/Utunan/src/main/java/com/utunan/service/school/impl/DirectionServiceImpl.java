package com.utunan.service.school.impl;

import com.utunan.mapper.school.DirectionMapper;
import com.utunan.pojo.base.school.Direction;
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

    @Override
    public Direction findDirectionByDirectionId(Long directionId) {
        return this.directionMapper.findDirectionByDirectionId(directionId);
    }

    @Override
    public void updateviewCount(Long directionId) {
        //查找directionId所对应的院校
        Direction direction = this.directionMapper.findDirectionByDirectionId(directionId);
        Long viewCount = direction.getViewCount();
       if(viewCount==null){
           //没有被访问过，设置为1
           this.directionMapper.setFirstViewCount(directionId);
        }else{
            //修改浏览数
           this.directionMapper.updateviewCount(directionId);
        }
    }
}
