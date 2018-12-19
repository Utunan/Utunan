package com.utunan.controller.user;

import com.utunan.pojo.base.user.User;
import com.utunan.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/checkpermit")
    @ResponseBody
    public String checkpermit(User user, HttpServletRequest request) {
        boolean bool = userService.isExist(user);
        if (bool) {
            return "200";
        }
        return "404";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpSession session, HttpServletRequest request) {
        String referer = request.getHeader("referer");
        Object obj = session.getAttribute("User");
        //用户未登录，转到用户登录界面
        session.setAttribute("PageSource", referer);
        if (obj == null) {
            return "login";
        }
        //用户已登录，转到用户个人中心
        return "redirect:/user";

    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, User account, HttpSession session) {
        String permit = request.getParameter("permit");
        account.setUserEmail(permit);
        account.setUserTelephone(permit);
        User user = userService.getUser(account);
        boolean bool = userService.isExist(account);
        if (!bool) {
            request.setAttribute("reply", "手机号未注册,请先注册");
            request.setAttribute("temppermit", permit);
            return "/register";
        }
        if (user != null) {
            request.removeAttribute("reply");
            session.setAttribute("User", user);
            String pageSource = (String) session.getAttribute("PageSource");
            Integer messageCount=userService.getUserMessageCount(user);
            session.setAttribute("messagecount",messageCount.toString());
            if (pageSource == null){
                return "redirect:/user";
            }
            else {
                session.removeAttribute("PageSource");
                return "redirect:" + pageSource;
            }
        } else {
            request.setAttribute("reply", "通行证或密码错误");
            request.setAttribute("temppermit", permit);
            return "login";
        }
    }

    @RequestMapping("loginout")
    public String loginout(HttpSession session,HttpServletRequest request) {
        session.removeAttribute("User");
        String referer = request.getHeader("referer");
        return "redirect:"+referer;
    }

}
