package com.utunan.service.admin;

import com.utunan.pojo.base.school.SchoolComment;

import java.util.List;

public interface AdminDirectionService {
    List<SchoolComment> getAllSchoolComment(int pageNum, int pageSize);
}
