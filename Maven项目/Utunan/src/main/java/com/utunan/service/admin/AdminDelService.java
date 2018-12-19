package com.utunan.service.admin;

import org.springframework.stereotype.Service;

@Service
public interface AdminDelService {

    //批量删除用户
    void delAllMember(Long[] a);

    //批量删除院系评论
    void delAllSchoolComment(Long[] b);

    //单个删除用户
    void delMember(Long userId);

    //删除单个学校评论
    void delSchoolComment(Long schoolcommentId);
}
