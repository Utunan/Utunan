package com.utunan.interceptor.user;

import com.utunan.pojo.base.user.User;
import com.utunan.service.user.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserSessionInterceptor implements HandlerInterceptor {

    private  static  final Logger LOGGER =Logger.getLogger(UserSessionInterceptor.class);
    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session= request.getSession();
        User user=(User)session.getAttribute("User");
        if(user==null){
            response.sendRedirect("/login");
            return false;
        }else{

            User checkUser =userService.getUser(user);
            if (user.getUserPassword().equals(checkUser.getUserPassword())){
                session.setAttribute("User",checkUser);
                return true;
            }else{
                session.removeAttribute("User");
                response.sendRedirect("/login");
            }
        }
        return  true;
    }
}
