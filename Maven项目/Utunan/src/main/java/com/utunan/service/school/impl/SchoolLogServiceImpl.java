package com.utunan.service.school.impl;

import com.utunan.mapper.school.SchoolLogMapper;
import com.utunan.pojo.base.school.DirectionComment;
import com.utunan.pojo.base.user.DirectionCollector;
import com.utunan.service.school.SchoolLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("schoolLogService")
public class SchoolLogServiceImpl implements SchoolLogService {
	@Autowired
	private SchoolLogMapper schoolLogMapper;

	@Override
	public DirectionCollector findGreatByUserAndDirection(Long userId, Long directionId) {
		DirectionCollector directionCollector = this.schoolLogMapper.findGreatByUserAndDirection(userId, directionId);
		return directionCollector;
	}

	@Override
	public DirectionComment findCommentByUserAndDirection(Long userId, Long directionId) {
		DirectionComment directionComment = this.schoolLogMapper.findCommentByUserAndDirection(userId, directionId);
		return directionComment;
	}
}
