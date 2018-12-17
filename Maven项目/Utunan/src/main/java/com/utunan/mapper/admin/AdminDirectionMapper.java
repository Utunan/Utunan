package com.utunan.mapper.admin;

import com.utunan.pojo.base.school.SchoolComment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminDirectionMapper {
    List<SchoolComment> getAllSchoolComment();
}
