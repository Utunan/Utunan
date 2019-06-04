package com.utunan.service.school;

import com.utunan.pojo.base.school.Direction;
import com.utunan.pojo.base.school.DirectionComment;
import com.utunan.pojo.base.user.DirectionCollector;

import java.util.List;

public interface SchoolLogService {

    DirectionCollector findGreatByUserAndDirection(Long userId, Long directionId);
    DirectionComment findCommentByUserAndDirection(Long userId, Long directionId);

}
