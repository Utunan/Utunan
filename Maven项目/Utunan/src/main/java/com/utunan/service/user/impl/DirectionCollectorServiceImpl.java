package com.utunan.service.user.impl;

import com.github.pagehelper.PageHelper;
import com.utunan.mapper.user.DirectionCollectorMapper;
import com.utunan.pojo.school.Direction;
import com.utunan.pojo.user.User;
import com.utunan.service.user.DirectionCollectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("directionCollectorService")
public class DirectionCollectorServiceImpl implements DirectionCollectorService {

    @Autowired
    private DirectionCollectorMapper directionCollectorMapper;

    @Override
    public List<Direction> getUserSchoolCollector(User user,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Direction> list=directionCollectorMapper.selectAllByUser(user);
        return list;
    }
}
