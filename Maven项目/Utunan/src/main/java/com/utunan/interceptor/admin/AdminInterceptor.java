package com.utunan.interceptor.admin;

import com.utunan.pojo.base.user.User;
import com.utunan.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

public class AdminInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session= request.getSession();
        User user=(User)session.getAttribute("User");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out=response.getWriter();

        if(user==null){
            response.sendRedirect("/admin/login");
            return false;
        }else{

            User checkUser =userService.getUser(user);
            if (user.getUserPassword().equals(checkUser.getUserPassword())){
                session.setAttribute("User",checkUser);
                if(!user.getUserIdentity().equals("1")){
                    response.sendRedirect("/user");
                    return false;
                }
                return true;
            }else{

                session.removeAttribute("User");
                response.sendRedirect("/admin/login");
                return false;
            }
        }
    }
}
