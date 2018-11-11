package com.utunan.controller;

import com.aliyuncs.exceptions.ClientException;
import com.utunan.util.RandUtil;
import com.utunan.util.SmsDemo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class CodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @RequestMapping("/code")
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userTelephone=request.getParameter("userTelephone");
        response.setCharacterEncoding("UTF-8");
        //获取验证码
        RandUtil random=new RandUtil();
        String code=random.getRandNum();

        //获取session
        HttpSession session=request.getSession();
        //将验证码存储到session中
        session.setAttribute("code",code);

        SmsDemo smsDemo=new SmsDemo();
        try {
            smsDemo.sendSms(userTelephone,code);
        } catch (ClientException e) {
            e.printStackTrace();
        }
        response.getWriter().write("true");
        response.flushBuffer();


    }
}
