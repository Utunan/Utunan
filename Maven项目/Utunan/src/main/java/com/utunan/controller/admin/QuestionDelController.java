package com.utunan.controller.admin;

import com.utunan.service.admin.QuestionDelService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class QuestionDelController {
    @Autowired
    private QuestionDelService questionDelService;

    //批量删除数据结构题目
    @RequestMapping(value = "/delalldsquestion",method = RequestMethod.GET)
    @ResponseBody
    public void delalldsquestion(@Param("d") String d, HttpServletRequest request){
        String[] data=d.split(",");
        Long[] b=new Long[data.length];
        for (int i = 0; i <data.length ; i++) {
            b[i]=new Long(data[i]) ;
        }
        this.questionDelService.delAllDsQuestion(b);
    }



    //批量删除C语言
    @RequestMapping(value = "/delallcquestion",method = RequestMethod.GET)
    @ResponseBody
    public void delallcquestion(@Param("d") String d, HttpServletRequest request){
        String[] data=d.split(",");
        Long[] b=new Long[data.length];
        for (int i = 0; i <data.length ; i++) {
            b[i]=new Long(data[i]) ;
        }
        this.questionDelService.delAllCQuestion(b);
    }


    //批量删除操作系统
    @RequestMapping(value = "/delallosquestion",method = RequestMethod.GET)
    @ResponseBody
    public void delallosquestion(@Param("d") String d, HttpServletRequest request){
        String[] data=d.split(",");
        Long[] b=new Long[data.length];
        for (int i = 0; i <data.length ; i++) {
            b[i]=new Long(data[i]) ;
        }
        this.questionDelService.delAllOsQuestion(b);
    }

    //批量删除组成原理题目
    @RequestMapping(value = "/delallconstitute",method = RequestMethod.GET)
    @ResponseBody
    public void delallconstitute(@Param("d") String d, HttpServletRequest request){
        String[] data=d.split(",");
        Long[] b=new Long[data.length];
        for (int i = 0; i <data.length ; i++) {
            b[i]=new Long(data[i]) ;
        }
        this.questionDelService.delAllConstitute(b);
    }

    //批量删除网络原理题目
    @RequestMapping(value = "/delallnetwork",method = RequestMethod.GET)
    @ResponseBody
    public void delallnetwork(@Param("d") String d, HttpServletRequest request){
        String[] data=d.split(",");
        Long[] b=new Long[data.length];
        for (int i = 0; i <data.length ; i++) {
            b[i]=new Long(data[i]) ;
        }
        this.questionDelService.delAllNetwork(b);
    }


    //批量删除软件工程题目
    @RequestMapping(value = "/delallsequestion",method = RequestMethod.GET)
    @ResponseBody
    public void delallsequestion(@Param("d") String d, HttpServletRequest request){
        String[] data=d.split(",");
        Long[] b=new Long[data.length];
        for (int i = 0; i <data.length ; i++) {
            b[i]=new Long(data[i]) ;
        }
        this.questionDelService.delAllSeQuestion(b);
    }
}
