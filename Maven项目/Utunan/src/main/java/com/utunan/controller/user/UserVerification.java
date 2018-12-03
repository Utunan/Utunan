package com.utunan.controller.user;


import com.aliyuncs.exceptions.ClientException;
import com.utunan.mapper.user.UserMapper;
import com.utunan.pojo.base.user.User;
import com.utunan.service.user.UserService;
import com.utunan.util.RandUtil;
import com.utunan.util.SmsDemo;
import com.utunan.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class UserVerification {

    @Autowired
    private UserService userService;

    @RequestMapping("/code")
    @ResponseBody
    public void code(HttpServletRequest request, HttpServletResponse response){
        String userTelephone=request.getParameter("userTelephone");
        response.setCharacterEncoding("UTF-8");

        //获取验证码
        RandUtil random=new RandUtil();
        String code=random.getRandNum();

        //将验证码保存在session中
        request.getSession().setAttribute("code",code);

        SmsDemo smsDemo=new SmsDemo();
        try {
            smsDemo.sendSms(userTelephone,code);
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/telecode")
    @ResponseBody
    public void telecode(HttpServletRequest request,HttpServletResponse response){
        String userTelephone=request.getParameter("newTelephone");
        response.setCharacterEncoding("UTF-8");

        //获取验证码
        RandUtil random=new RandUtil();
        String code=random.getRandNum();

        //将验证码保存在session中
        request.getSession().setAttribute("code",code);

        SmsDemo smsDemo=new SmsDemo();
        try {
            smsDemo.sendSms(userTelephone,code);
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/user/changepassword")
    public String changepassword(HttpSession session,HttpServletRequest request){
        request.removeAttribute("passwordreply");
        String oldpassword=request.getParameter("oldpassword");
        String newpassword=request.getParameter("newpassword");
        String repassword=request.getParameter("repassword");
        System.out.println(oldpassword+newpassword+repassword);
        if(!newpassword.equals(repassword)){
            request.setAttribute("passwordreply","输入的密码不相同,请重新输入~");
            return "/user/settings";
        }
        if(oldpassword.equals(newpassword)){
            request.setAttribute("passwordreply","新密码不能和原密码相同~");
            return "/user/settings";
        }
        if(!StringUtil.checkPasswordFormat(newpassword)){
            request.setAttribute("passwordreply","密码格式错误,请重新填写更改信息~");
            return "/user/settings";
        }
        User user= (User) session.getAttribute("User");
        user.setUserPassword(newpassword);
        User updateUser=userService.changeUserPassword(user);
        session.setAttribute("User",updateUser);
        return "redirect:/user/settings";
    }
}
