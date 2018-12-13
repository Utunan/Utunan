package com.utunan.controller.admin;


import com.utunan.service.admin.DelMemberService;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DelMemberController {

    @Autowired
    private DelMemberService delMemberService;
    @RequestMapping(value = "/delallmember",method = RequestMethod.GET)
    public void delallmember(@Param("d") String d,HttpServletRequest request){
        String[] data=d.split(",");
        Long[] a=new Long[data.length];
        for (int i = 0; i <data.length ; i++) {
            a[i]=new Long(data[i]) ;
        }
        //this.delMemberService.delAllMember(a);
    }
}
