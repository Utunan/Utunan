package com.utunan.controller.common;

import com.utunan.pojo.base.user.Member;
import com.utunan.pojo.base.user.User;
import com.utunan.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

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
    public String User(HttpServletRequest request, @PathVariable String userId){
        Member member=userService.getUserById(userId);
        if(member!=null)
            request.setAttribute("Member",member);
        System.out.println(member);
        return "/user/member";
    }

}
