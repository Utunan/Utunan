package com.utunan.service.school;

import com.utunan.pojo.school.School;

import java.util.List;

public interface SchoolService {
    School queryByName(String schoolName);
    List<School> queryBy();
}
