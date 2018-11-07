package com.utunan.mapper;


import com.utunan.pojo.school.School;

import java.util.List;

public interface SchoolMapper {
    School queryByName(String schoolName);
    List<School> queryBy();
}
