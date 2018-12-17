package com.utunan.service.admin;

import org.springframework.stereotype.Service;

@Service
public interface AdminDelService {

    //批量删除用户
    void delAllMember(Long[] a);

    //批量删除院系评论
    void delAllSchoolComment(Long[] b);
}
