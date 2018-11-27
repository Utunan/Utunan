package com.utunan.service.school.impl;

import com.utunan.mapper.school.SchoolMapper;
import com.utunan.pojo.school.School;
import com.utunan.service.school.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("schoolService")
public class SchoolServiceImpl  implements SchoolService {

    @Autowired
    private SchoolMapper schoolMapper;

    /*
     * @author  王碧云
     * @description 查询所有的学校
     * @date  20:12 2018/11/27/027
     * @param  []
     * @return  java.util.List<com.utunan.pojo.school.School>
     */
    @Override
    public List<School> findAllSchool() {
        return this.schoolMapper.findAllSchool();
    }
}
