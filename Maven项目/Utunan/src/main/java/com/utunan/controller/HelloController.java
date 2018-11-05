package com.utunan.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//  实现一个Conteoller接口的方式
public class HelloController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mav=new ModelAndView();
        mav.addObject("user","zhengwei");
        mav.setViewName("user");
        return mav;
    }
}
