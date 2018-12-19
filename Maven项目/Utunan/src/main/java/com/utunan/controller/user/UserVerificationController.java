package com.utunan.controller.user;


import com.aliyuncs.exceptions.ClientException;
import com.utunan.mapper.user.UserMapper;
import com.utunan.pojo.base.user.User;
import com.utunan.service.user.UserService;
import com.utunan.util.ImgUtil;
import com.utunan.util.RandUtil;
import com.utunan.util.SmsDemo;
import com.utunan.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Date;

@Controller
public class UserVerificationController {

    @Autowired
    private UserService userService;

    @RequestMapping("/code")
    @ResponseBody
    public String code(HttpServletRequest request, HttpServletResponse response){
        String userTelephone=request.getParameter("userTelephone");
        response.setCharacterEncoding("UTF-8");

        //获取验证码
        RandUtil random=new RandUtil();
        String code=random.getRandNum();

        //将验证码保存在session中
        request.getSession().setAttribute("code",code);

        SmsDemo smsDemo=new SmsDemo();
        try {
            request.getSession().setAttribute("registertel",userTelephone);
            smsDemo.sendSms(userTelephone,code);
        } catch (ClientException e) {
            e.printStackTrace();
            return "unsuccess";
        }
        return "success";
    }

    @RequestMapping("/telecode")
    @ResponseBody
    public void telecode(HttpServletRequest request,HttpServletResponse response){
        String checknewtelephone=request.getParameter("checknewtelephone");
        request.getSession().setAttribute("checknewtelephone",checknewtelephone);
        response.setCharacterEncoding("UTF-8");
        User user=(User)request.getSession().getAttribute("User");
        //获取验证码
        RandUtil random=new RandUtil();
        String code=random.getRandNum();

        //将验证码保存在session中
        request.getSession().setAttribute("telecode",code);
        SmsDemo smsDemo=new SmsDemo();
        try {
            smsDemo.sendSms(checknewtelephone    ,code);
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/emailcode")
    @ResponseBody
    public void emailcode(HttpServletRequest request,HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        User user=(User)request.getSession().getAttribute("User");
        //获取验证码
        RandUtil random=new RandUtil();
        String code=random.getRandNum();
        System.out.println(user.getUserTelephone());
        //将验证码保存在session中
        request.getSession().setAttribute("emailcode",code);

        SmsDemo smsDemo=new SmsDemo();
        try {
            smsDemo.sendSms(user.getUserTelephone(),code);
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }

}
