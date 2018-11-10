package com.utunan.controller.user;

import com.utunan.pojo.user.User;
import com.utunan.service.user.UserService;
import com.utunan.service.user.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class loginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(HttpServletRequest request, User user, HttpSession session) {
        user.setUserEmail(request.getParameter("permit"));
        user.setUserTelephone(request.getParameter("permit"));
        User user1=userService.getUser(user);
        System.out.println(user);
        if(user1!=null) {
            return "redirect:/user/";
        }else{
            return "login";
        }
    }
}
