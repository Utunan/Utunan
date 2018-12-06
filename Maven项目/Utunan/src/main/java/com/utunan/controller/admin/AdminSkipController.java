package com.utunan.controller.admin;

import com.github.pagehelper.PageInfo;
import com.utunan.pojo.base.user.User;
import com.utunan.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminSkipController {

    @Autowired
    private UserService userService;

    @RequestMapping("")
    public String admin(){
        return "/admin/index";
    }
    @RequestMapping("welcome")
    public String welcome(){
        return "/admin/welcome";
    }
    @RequestMapping(value = "/login",method= RequestMethod.GET)
    public String login(HttpSession session){
        User user= (User) session.getAttribute("User");
        if(user==null)
            return "/admin/login";
        return "/admin/";
    }
    @RequestMapping("memberlist")
    public String meberlist(HttpSession session, HttpServletRequest request){
        List<User> users=null;
        String pageNum = request.getParameter("pageNum");
        if (pageNum == null ||pageNum == ""|| Integer.parseInt(pageNum) <= 0)
            users = userService.getAllUser(1, 10);
        else
            users = userService.getAllUser(Integer.parseInt(pageNum), 10);
        request.setAttribute("PageInfo",new PageInfo(users,5));
        session.setAttribute("Users",users);
        return "admin/memberlist";
    }
    @RequestMapping("memberadd")
    public  String memberadd(){
        return "/admin/memberadd";
    }
}
