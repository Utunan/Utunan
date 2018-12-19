package com.utunan.controller.user;

import com.utunan.pojo.base.user.User;
import com.utunan.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class MessageController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user/message/update")
    @ResponseBody
    private String umu(HttpSession session, HttpServletRequest request){
        User user=(User)session.getAttribute("User");
        Integer messageCount=userService.getUserMessageCount(user);
        session.setAttribute("messagecount",messageCount.toString());
        String messageId=request.getParameter("messageId");
        userService.changeMessageIsView(messageId);
        return "{ \"state\":\"success\" }";
    }

}
