package com.utunan.service.admin.Impl;

import com.utunan.mapper.admin.DelMemberMapper;
import com.utunan.service.admin.DelMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("DelMemberService")
public class DelMemberServiceImpl implements DelMemberService {
    @Autowired
    private DelMemberMapper delMemberMapper;

    //批量删除用户
    @Override
    public void delAllMember(Long[] a) {
        this.delMemberMapper.delAllMember(a);
    }
}
