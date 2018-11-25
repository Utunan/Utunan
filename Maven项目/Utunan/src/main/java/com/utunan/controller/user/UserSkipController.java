package com.utunan.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 负责用户个人中心的跳转
 * 这个文件除了jsp重命名之外,不要做任何添加删除
 * 如果有关用户操作,请到其他的Controller
 */
@Controller
@RequestMapping("/user")
public class UserSkipController {

    @RequestMapping("")
    public String user() {
        return "/user/myspace";
    }

    @RequestMapping("myspace")
    public String myspace(){
        return "/user/myspace";
    }

    @RequestMapping("statistics")
    public String statistics(){
        return  "/user/statistics";
    }

    @RequestMapping("publishpost")
    public String publishpost(){
        return "/user/publishpost";
    }

    @RequestMapping("publishreply")
    public String publishreply(){
        return "/user/publishreply";
    }

    @RequestMapping("collectschool")
    public String collectschool(){
        return "/user/collectschool";
    }

    @RequestMapping("collectmatter")
    public String collectmatter(){
        return "/user/collectmatter";
    }

    @RequestMapping("collectpost")
    public String collectpost(){
        return "/user/collectpost";
    }

}
