package com.utunan.service.school.impl;

import com.utunan.mapper.school.PublishDirectionMapper;
import com.utunan.pojo.inherit.school.PublishDirection;
import com.utunan.service.school.PublishDirectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 王碧云
 * @description: 研究方向
 * @date 2018/11/29/029 19:28
 */
@Service("publishDirectionService")
public class PublishDirectionServiceImpl implements PublishDirectionService {

    @Autowired
    private PublishDirectionMapper publishDirectionMapper;


    @Override
    public PublishDirection findDirectionByDirectionId(String directionId,String sort) {
        PublishDirection publishDirection = null;
        if(sort==null || "".equals(sort) || sort.equals("时间")){
            publishDirection = this.publishDirectionMapper.findDirectionByDirectionId(directionId);
        }else {
            publishDirection = this.publishDirectionMapper.findDirectionOrderByPraiseCount(directionId);
        }
        return publishDirection;
    }
}
