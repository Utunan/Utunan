package com.utunan.service.school.impl;

import com.utunan.mapper.school.SchoolMapper;
import com.utunan.pojo.base.school.School;
import com.utunan.service.school.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("schoolService")
public class SchoolServiceImpl  implements SchoolService {

    @Autowired
    private SchoolMapper schoolMapper;

}
