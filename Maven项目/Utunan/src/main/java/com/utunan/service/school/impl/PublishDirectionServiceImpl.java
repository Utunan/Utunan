package com.utunan.service.school.impl;

import com.github.pagehelper.PageHelper;
import com.utunan.mapper.school.PublishDirectionMapper;
import com.utunan.mapper.school.SchoolMapper;
import com.utunan.pojo.base.school.School;
import com.utunan.pojo.inherit.school.PublishDirection;
import com.utunan.service.school.PublishDirectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public PublishDirection findDirectionByDirectionName(String directionName) {
        return this.publishDirectionMapper.findDirectionByDirectionName(directionName);
    }
}
