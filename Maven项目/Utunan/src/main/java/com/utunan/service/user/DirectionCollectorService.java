package com.utunan.service.user;

import com.utunan.pojo.base.school.Direction;
import com.utunan.pojo.base.user.User;

import java.util.List;

public interface DirectionCollectorService {
    List<Direction> getUserDirectionCollector(User user,int pageNum,int pageSize);
}
