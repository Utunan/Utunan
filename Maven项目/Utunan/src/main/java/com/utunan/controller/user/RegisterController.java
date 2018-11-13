package com.utunan.controller.user;


import com.utunan.pojo.user.User;
import com.utunan.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/register",method = RequestMethod.GET)
    public String register(HttpSession session){
        Object obj =session.getAttribute("user");
        if(obj==null){
            return  "register";
        }else{
            return "redirect:/user/";
        }
    }

    @RequestMapping(value="/register",method =RequestMethod.POST)
    public String register(User user){
        userService.saveUser(user);
        return "";
    }
}
