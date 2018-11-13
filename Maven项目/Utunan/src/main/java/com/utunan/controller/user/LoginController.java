package com.utunan.controller.user;

import com.utunan.pojo.user.User;
import com.utunan.service.user.UserService;
import com.utunan.service.user.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/checkpermit")
    @ResponseBody
    public String checkpermit(User user,HttpServletRequest request){
        String permit=request.getParameter("permit");
        user.setUserEmail(permit);
        user.setUserTelephone(permit);
        boolean bool=userService.isExist(user);
        if(bool) {
            return "successful";
        }
        return "unsuccessful";
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpSession session) {
        Object obj=session.getAttribute("user");
        if(obj==null){
            return "login";
        }else{
            return "redirect:/user";
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, User user, HttpSession session) {
        String permit=request.getParameter("permit");
        user.setUserEmail(permit);
        user.setUserTelephone(permit);
        User user1 = userService.getUser(user);
        if (user1 != null) {
            request.removeAttribute("reply");
            session.setAttribute("user", user1);
            return "redirect:/user/";
        } else {
            request.setAttribute("reply", "通行证或密码错误");
            request.setAttribute("temppermit",permit);
            return "login";
        }
    }
}
