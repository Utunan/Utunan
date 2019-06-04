package com.utunan.mapper.school;


import com.utunan.pojo.base.school.DirectionComment;
import com.utunan.pojo.base.user.DirectionCollector;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface SchoolLogMapper {
	DirectionCollector findGreatByUserAndDirection(@Param("userId") Long userId, @Param("directionId") Long directionId);
	DirectionComment findCommentByUserAndDirection(@Param("userId") Long userId, @Param("directionId") Long directionId);

}
