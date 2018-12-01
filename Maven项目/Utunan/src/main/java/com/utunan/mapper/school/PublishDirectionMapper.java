package com.utunan.mapper.school;

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
    /*王碧云 查询所有的学校*/
    List<PublishDirection> findAllSchool();
    /*王碧云 根据所有参数检索学校*/
    List<PublishDirection> findSchoolByAllParam(@Param("schoolProvince") String[] schoolProvince,
                                      @Param("schoolType") String[] schoolType,
                                      @Param("degreeTypeList") String[] degreeTypeList,
                                      @Param("mathList") String[] mathList,
                                      @Param("englishList") String[] englishList,
                                      @Param("directionName") String directionName);
}
