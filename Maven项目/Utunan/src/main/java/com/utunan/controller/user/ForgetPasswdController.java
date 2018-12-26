package com.utunan.controller.user;


import com.utunan.pojo.base.user.User;
import com.utunan.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/forgetpasswd")
public class ForgetPasswdController {

    @Autowired
    private UserService userService;

    @RequestMapping(path="",method = RequestMethod.GET)
    public String forgetPasswd(){
        return "forgetpasswd";
    }
    @RequestMapping(path="",method = RequestMethod.POST)
    public String changePasswd(User user, HttpSession session, HttpServletRequest request,String code){
        boolean bool=userService.isExist(user);
        if(!bool){
            request.setAttribute("reply","该手机号不存在,请先<a href='/register'>注册</a>");
            return "forgetpasswd";
        }
        String repassword=request.getParameter("rpassword");
        if(!user.getUserPassword().equals(repassword)){
            request.setAttribute("reply","两次输入的密码不相同,请重新输入.");
            return "forgetpasswd";
        }

        String checkcode= (String) session.getAttribute("forgetCode");
        if(!checkcode.equals(code)){
            request.setAttribute("reply","验证码错误");
            return "forgetpasswd";
        }
        User updateUser = userService.changeUserPassword(user);
        session.setAttribute("User", updateUser);
        return "redirect:/user";
    }
}
