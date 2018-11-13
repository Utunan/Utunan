package com.utunan.controller.user;


import com.utunan.pojo.user.User;
import com.utunan.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/register",method = RequestMethod.GET)
    public String register(){
        return "redirect:/user/";
    }

    @RequestMapping(value="/register",method =RequestMethod.POST)
    public String register(User user, HttpServletRequest request){
        boolean bool=userService.isExist(user);
        if(bool){
            request.setAttribute("reply","该用户已被注册");
            return "register";
        }
        userService.saveUser(user);
        return "redirect:/user/";
    }
}
