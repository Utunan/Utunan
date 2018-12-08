package com.utunan.service.admin.Impl;

import com.github.pagehelper.PageHelper;
import com.utunan.mapper.admin.AdminDirectionMapper;
import com.utunan.pojo.base.school.Direction;
import com.utunan.service.admin.AdminDirectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("adminDirectionService")
public class AdminDirectionServiceImpl implements AdminDirectionService {

    @Autowired
    private AdminDirectionMapper adminDirectionMapper;

    @Override
    public List<Direction> getAllDirection(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Direction> directions=adminDirectionMapper.selectAllDirection();
        return  directions;
    }
}
