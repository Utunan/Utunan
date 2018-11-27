package com.utunan.controller.user;

import com.utunan.pojo.school.Direction;
import com.utunan.pojo.user.User;
import com.utunan.service.user.DirectionCollectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 负责用户个人中心的跳转
 * 这个文件除了jsp重命名之外,不要做任何添加删除
 * 如果有关用户操作,请到其他的Controller
 */
@Controller
@RequestMapping("/user")
public class UserSkipController {

    @Autowired
    private DirectionCollectorService directionCollectorService;

    @RequestMapping("")
    public String user() {
        return "/user/myspace";
    }

    @RequestMapping("myspace")
    public String myspace() {
        return "/user/myspace";
    }

    @RequestMapping("statistics")
    public String statistics() {
        return "/user/statistics";
    }

    @RequestMapping("publishpost")
    public String publishpost() {
        return "/user/publishpost";
    }

    @RequestMapping("publishreply")
    public String publishreply() {
        return "/user/publishreply";
    }

    @RequestMapping("schoolcollector")
    public String collectschool(HttpSession session) {
        User user = (User) session.getAttribute("User");
        List<Direction> directions = directionCollectorService.getUserSchoolCollector(user,1,10);
        session.setAttribute("Directions", directions);
        System.out.println(directions);
        return "user/schoolcollector";
    }

    @RequestMapping("mattercollector")
    public String collectmatter() {
        return "user/mattercollector";
    }

    @RequestMapping("postcollector")
    public String collectpost() {
        return "user/postcollector";
    }

}
