package com.utunan.mapper.school;

import com.utunan.pojo.base.school.Direction;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DirectionMapper {

    /*王碧云 查询所有的研究方向*/
    List<Direction> findAllDirection();

}
