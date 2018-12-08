package com.utunan.service.admin;

import com.utunan.pojo.base.school.Direction;

import java.util.List;

public interface AdminDirectionService {
    List<Direction> getAllDirection(int pageNum,int pageSize);
}
