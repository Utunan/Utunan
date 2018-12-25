package com.utunan.controller.common;

import com.utunan.pojo.base.user.Member;
import com.utunan.pojo.base.user.User;
import com.utunan.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

    @RequestMapping("/followuser")
    @ResponseBody
    public String followuer(HttpSession session, HttpServletRequest request) {
        try {
            String followedId = request.getParameter("followedId");
            User user = (User) request.getSession().getAttribute("User");
            if (user == null)
                return "{\"state\":\"nouser\",\"userstate\":\"no\"}";
            userService.saveFollow(user.getUserId(), Long.parseLong(followedId));
            return "{\"state\":\"success\",\"userstate\":\"yes\"}";
        } catch (Exception e) {
            return "{\"state\":\"unsuccess\",\"userstate\":\"no\"}";
        }
    }

    @RequestMapping("/cancel")
    @ResponseBody
    public String cancelFollow(HttpServletRequest request) {
        try {
            String followedId = request.getParameter("followedId");
            User user = (User) request.getSession().getAttribute("User");
            if (user == null)
                return "{\"state\":\"nouser\",\"userstate\":\"no\"}";
            userService.cancelFollow(Long.parseLong(followedId), user.getUserId());
            return "{\"state\":\"nouser\",\"userstate\":\"yes\"}";
        } catch (Exception e) {
            return "{\"state\":\"nouser\",\"userstate\":\"no\"}";
        }
    }

    @RequestMapping("/{userId}")
    public String User(HttpServletRequest request, @PathVariable String userId) {
        Member member = userService.getUserById(userId);
        User user = (User) request.getSession().getAttribute("User");

        System.out.println(user);
        if (member == null) {
            return "redirect:/user";
        }

        if (user == null) {
            member.setIsfollow(false);

        } else {
            if (member.getUser().getUserId().equals(user.getUserId())) {
                return "redirect:/user";
            }
            Boolean bool = userService.isFollow(Long.parseLong(userId), user.getUserId()) == 1 ? true : false;
            member.setIsfollow(bool);
        }

        request.setAttribute("Member", member);
        return "/user/member";
    }

}
