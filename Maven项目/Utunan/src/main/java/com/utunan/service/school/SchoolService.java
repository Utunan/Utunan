package com.utunan.service.school;

import com.utunan.pojo.school.School;

import java.util.List;

public interface SchoolService {

    /*
     * @author  王碧云
     * @description 查询所有的学校
     * @date  20:10 2018/11/27/027
     * @param  []
     * @return  java.util.List<com.utunan.pojo.school.School>
     */
    List<School> findAllSchool();

}
