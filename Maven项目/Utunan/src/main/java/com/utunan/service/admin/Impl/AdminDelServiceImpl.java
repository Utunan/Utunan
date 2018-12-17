package com.utunan.service.admin.Impl;

import com.utunan.mapper.admin.AdminDelMapper;
import com.utunan.service.admin.AdminDelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("DelMemberService")
public class AdminDelServiceImpl implements AdminDelService {
    @Autowired
    private AdminDelMapper adminDelMapper;

    //批量删除用户
    @Override
    public void delAllMember(Long[] a) {
        this.adminDelMapper.delAllMember(a);
    }


    //批量删除院系评论

    @Override
    public void delAllSchoolComment(Long[] b) {
        this.adminDelMapper.delAllSchoolComment(b);
    }
}
