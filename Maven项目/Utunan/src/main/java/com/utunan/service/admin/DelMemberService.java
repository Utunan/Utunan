package com.utunan.service.admin;

import org.springframework.stereotype.Service;

@Service
public interface DelMemberService {

    //批量删除用户
    void delAllMember(Long[] a);
}
