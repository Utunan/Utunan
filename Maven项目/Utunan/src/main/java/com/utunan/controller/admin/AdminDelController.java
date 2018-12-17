package com.utunan.controller.admin;


import com.utunan.service.admin.AdminDelService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AdminDelController {

    @Autowired
    private AdminDelService adminDelService;



    @RequestMapping(value = "/delallmember",method = RequestMethod.GET)
    @ResponseBody
    public void delallmember(@Param("d") String d,HttpServletRequest request){
        String[] data=d.split(",");
        Long[] a=new Long[data.length];
        for (int i = 0; i <data.length ; i++) {
            a[i]=new Long(data[i]) ;
        }
        this.adminDelService.delAllMember(a);
    }

    @RequestMapping(value = "/delallschoolcomment",method = RequestMethod.GET)
    @ResponseBody
    public void delallschoolcomment(@Param("d") String d,HttpServletRequest request){
        String[] data=d.split(",");
        Long[] b=new Long[data.length];
        for (int i = 0; i <data.length ; i++) {
            b[i]=new Long(data[i]) ;
        }
        this.adminDelService.delAllSchoolComment(b);
    }
}
