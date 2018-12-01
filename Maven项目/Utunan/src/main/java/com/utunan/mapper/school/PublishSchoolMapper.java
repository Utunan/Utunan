package com.utunan.mapper.school;

import com.utunan.pojo.inherit.school.PublishDirection;
import com.utunan.pojo.inherit.school.PublishSchool;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 王碧云
 * @description: TODO
 * @date 2018/12/1/001 18:55
 */
@Mapper
@Repository
public interface PublishSchoolMapper {

    /*王碧云 查询所有的学校*/
    List<PublishSchool> findAllSchool();
    /*王碧云 根据所有参数检索学校*/
    List<PublishSchool> findSchoolByAllParam(@Param("schoolProvince") String[] schoolProvince,
                                                @Param("schoolType") String[] schoolType,
                                                @Param("degreeTypeList") String[] degreeTypeList,
                                                @Param("mathList") String[] mathList,
                                                @Param("englishList") String[] englishList,
                                                @Param("directionName") String directionName);

}
