package com.utunan.controller.admin;

import com.utunan.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AdminVerificationController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/admin/login",method = RequestMethod.POST)
    @ResponseBody
    public String login(HttpSession session, HttpServletRequest request){

        return "successful";
    }

}
