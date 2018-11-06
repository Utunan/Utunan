package com.utunan.service.school;


import com.utunan.pojo.School;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SchoolService {
    School queryByName(String schoolName);
    List<School> queryBy();
}
