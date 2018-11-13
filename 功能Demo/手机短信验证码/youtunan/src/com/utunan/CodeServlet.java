package com.utunan;

import com.aliyuncs.exceptions.ClientException;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;


public class CodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("111111111111111111111111");
        String phoneNumber=request.getParameter("phoneNumber");
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
            smsDemo.sendSms(phoneNumber,code);
        } catch (ClientException e) {
            e.printStackTrace();
        }
        response.getWriter().write("true");
        response.flushBuffer();


    }
}
