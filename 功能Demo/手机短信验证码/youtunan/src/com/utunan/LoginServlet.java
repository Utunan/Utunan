package com.utunan;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        response.setCharacterEncoding("UTF-8");
        if(request.getSession().getAttribute("code").equals(code)){
            response.getWriter().write("true");
        }else {
            response.getWriter().write("false");
        }
        response.flushBuffer();
    }
}
