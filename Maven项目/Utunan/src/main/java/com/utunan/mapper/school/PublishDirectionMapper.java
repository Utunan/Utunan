package com.utunan.mapper.school;

import com.utunan.pojo.base.school.Direction;
import com.utunan.pojo.base.school.School;
import com.utunan.pojo.inherit.school.PublishDirection;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 王碧云
 * @description: TODO
 * @date 2018/11/29/029 19:13
 */
@Mapper
@Repository
public interface PublishDirectionMapper {
    /*查询研究方向详情(按时间排序)*/
    PublishDirection findDirectionByDirectionId(@Param("directionId") String directionId);
    /*查询研究方向详情(按热度排序)*/
    PublishDirection findDirectionOrderByPraiseCount(@Param("directionId") String directionId);

}
