package com.utunan.controller.user;

import com.utunan.pojo.user.User;
import com.utunan.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("")
    public String user(HttpSession session) {
        User user = (User) session.getAttribute("User");
        if (user == null)
            return "redirect:/login";
        User checkuser = userService.getUser(user);
        if (!user.getUserPassword().equals(checkuser.getUserPassword()))
            return "redirect:/register";
        session.setAttribute("User", checkuser);
        return "/user/myspace";
    }

    @RequestMapping("/changeInfo")
    public String changeInfo(User user) {
        userService.changeInfo(user);
        return "redirect:/user";
    }
}
