package com.utunan.mapper.school;

import com.utunan.pojo.base.school.Direction;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DirectionMapper {

    /*王碧云 查询所有的研究方向*/
    List<Direction> findAllDirection();
    /*王碧云 查询研究方向通过Id*/
    Direction findDirectionByDirectionId(@Param("directionId") Long directionId);
    /*王碧云 修改网页浏览次数*/
    Long updateviewCount(@Param("directionId") Long directionId);
    /*王碧云 设置初始访问量*/
    Long setFirstViewCount(@Param("directionId") Long directionId);
}
