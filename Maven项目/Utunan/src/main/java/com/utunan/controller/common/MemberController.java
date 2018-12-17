package com.utunan.controller.common;

import com.utunan.pojo.base.user.User;
import com.utunan.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private UserService userService;

    @RequestMapping("")
    public String member(){
        return "redirect:/user";
    }

    @RequestMapping("/{userId}")
    public String User(){
        User member =userService.getUser(new User());

        return "/user/member";
    }

}
