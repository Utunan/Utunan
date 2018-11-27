package com.utunan.service.user;

import com.utunan.pojo.school.Direction;
import com.utunan.pojo.user.User;

import java.util.List;

public interface DirectionCollectorService {
    List<Direction> getUserSchoolCollector(User user,int pageNum,int pageSize);
}
