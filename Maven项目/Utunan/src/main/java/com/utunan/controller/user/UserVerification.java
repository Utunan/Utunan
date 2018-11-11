package com.utunan.controller.user;


import com.aliyuncs.exceptions.ClientException;
import com.utunan.util.RandUtil;
import com.utunan.util.SmsDemo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class UserVerification {
    @RequestMapping("/checkPermit")
    public String checkPermit(HttpServletRequest request){
        return "";
    }

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
            smsDemo.sendSms(userTelephone,code);
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return "true";
    }

    @RequestMapping("/checkCode")
    @ResponseBody
    public String checkCode(HttpServletRequest request,HttpServletResponse response){
        String code = request.getParameter("code");
        response.setCharacterEncoding("UTF-8");
        if(request.getSession().getAttribute("code").equals(code)){
            return  "true";
        }else {
           return  "false";
        }
    }
}
