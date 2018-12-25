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
    public String member(HttpServletRequest request) {
        String referer = request.getHeader("referer");
        return "redirect:" + referer;
    }

    @RequestMapping("/{userId}")
    public String User(HttpServletRequest request, @PathVariable String userId) {
        Member member = userService.getUserById(userId);
        User user = (User) request.getSession().getAttribute("User");

        if (member == null) {
            return "redirect:/user";
        }

        if (user == null) {
            member.setIsfollow(false);
        } else {
            if (member.getUser().getUserId().equals(user.getUserId())) {
                return "redirect:/user";
            }
            member.setIsfollow(userService.isFollow(Long.parseLong(userId), user.getUserId())==1?true:false);
        }

        request.setAttribute("Member", member);
        return "/user/member";
    }

}
