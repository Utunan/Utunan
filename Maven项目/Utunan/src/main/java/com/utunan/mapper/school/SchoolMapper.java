package com.utunan.mapper.school;


import com.utunan.pojo.school.School;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface SchoolMapper {
    /*王碧云 查询所有的学校*/
    List<School> findAllSchool();
    /*王碧云 根据省份检索学校(通过学校找到该校的研究方向)*/
    List<School> findSchoolBySchoolProvince(@Param("schoolProvince") String[] schoolProvince);
    /*王碧云 根据学校类型检索学校(通过学校找到该校的研究方向)*/
    List<School> findSchoolBySchoolType(@Param("schoolType") String[] schoolType);
    /*王碧云 根据所有参数检索学校*/
    List<School> findSchoolByAllParam(@Param("schoolProvince") String[] schoolProvince,@Param("schoolType") String[] schoolType);
}
