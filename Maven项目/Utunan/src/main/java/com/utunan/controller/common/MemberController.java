package com.utunan.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {
    @RequestMapping("")
    public String member(){
        return "redirect:/user";
    }

    @RequestMapping("/{userId}")
    public String User(){
        return "/user/member";
    }

}
