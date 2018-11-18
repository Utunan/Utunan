package com.utunan.mapper.school;


import com.utunan.pojo.school.School;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface SchoolMapper {
    School queryByName(String schoolName);
    List<School> queryBy();
}
