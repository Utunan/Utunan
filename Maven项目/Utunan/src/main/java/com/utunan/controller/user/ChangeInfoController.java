package com.utunan.controller.user;

import com.utunan.pojo.user.User;
import com.utunan.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChangeInfoController {
    @Autowired
    private UserService userService;

    @RequestMapping("/user/changeInfo")
    public String changeInfo(User user){
        userService.changeInfo(user);
        return "redirect:/user";
    }
}
