package com.utunan.service.user.impl;

import com.utunan.mapper.user.SchoolCollectorMapper;
import com.utunan.pojo.school.Direction;
import com.utunan.pojo.user.SchoolCollector;
import com.utunan.pojo.user.User;
import com.utunan.service.user.SchoolCollectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service("schoolCollectorService")
public class SchoolCollectorServiceImpl implements SchoolCollectorService {

    @Autowired
    private SchoolCollectorMapper mapper;

    @Override
    public List<Direction> getUserSchoolCollector(User user) {
        List<Direction> list=mapper.selectSchoolCollector(user);
        return list;
    }
}
