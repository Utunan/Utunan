package com.utunan.controller.user;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.utunan.pojo.base.community.Quiz;
import com.utunan.pojo.base.school.Direction;
import com.utunan.pojo.base.user.User;
import com.utunan.pojo.inherit.user.PublishQuiz;
import com.utunan.service.user.DirectionCollectorService;
import com.utunan.service.user.PublishQuizService;
import com.utunan.service.user.QuizCollectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
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
    @Autowired
    private PublishQuizService publishQuizService;
    @Autowired
    private QuizCollectorService quizCollectorService;

    @RequestMapping("")
    public String user() {
        return "/user/myspace";
    }

    @RequestMapping("myspace")
    public String myspace() {
        return "/user/myspace";
    }

    @RequestMapping("follow")
    public String follow(){
        return  "/user/follow";
    }

    @RequestMapping("information")
    public String information(){
        return "/user/information";
    }

    @RequestMapping("statistics")
    public String statistics() {
        return "/user/statistics";
    }

    @RequestMapping("publishquiz")
    public String publishpost(HttpServletRequest request,HttpSession session) {
        User user = (User) session.getAttribute("User");
        String pageNum = request.getParameter("pageNum");
        List<Quiz> quizzes = null;
        if (pageNum == null ||pageNum == ""|| Integer.parseInt(pageNum) <= 0)
            quizzes =  publishQuizService.getUserPublishQuiz(user, 1, 5);
        else
            quizzes = publishQuizService.getUserPublishQuiz(user, Integer.parseInt(pageNum), 5);

        if(quizzes==null)
            return "/user/publishquiz";
        request.setAttribute("PageInfo",new PageInfo(quizzes,5));
        request.setAttribute("Quizzes", quizzes);
        return "/user/publishquiz";
    }

    @RequestMapping("publishreply")
    public String publishreply() {
        return "/user/publishreply";
    }

    @RequestMapping("directioncollector")
    public String collectschool(HttpSession session, HttpServletRequest request) {
        User user = (User) session.getAttribute("User");
        String pageNum = request.getParameter("pageNum");
        Page<Direction> directions = null;
        if (pageNum == null ||pageNum == ""|| Integer.parseInt(pageNum) <= 0)
            directions = (Page<Direction>) directionCollectorService.getUserDirectionCollector(user, 1, 10);
        else
            directions = (Page<Direction>) directionCollectorService.getUserDirectionCollector(user, Integer.parseInt(pageNum), 10);

        request.setAttribute("PageInfo",new PageInfo(directions,5));
        request.setAttribute("Directions", directions);
        return "/user/directioncollector";
    }

    @RequestMapping("questioncollector")
    public String collectmatter() {
        return "/user/questioncollector";
    }

    @RequestMapping("quizcollector")
    public String collectpost(HttpSession session,HttpServletRequest request) {

        User user = (User) session.getAttribute("User");
        String pageNum = request.getParameter("pageNum");

        List<Quiz> quizzes = null;

        if (pageNum == null ||pageNum == ""|| Integer.parseInt(pageNum) <= 0)
            quizzes = quizCollectorService.getQuizCollector(user, 1, 8);
        else
            quizzes = quizCollectorService.getQuizCollector(user, Integer.parseInt(pageNum), 8);

        if(quizzes==null)
            return "/user/quizcollector";
        request.setAttribute("PageInfo",new PageInfo(quizzes,5));
        request.setAttribute("Quizzes", quizzes);
        return "/user/quizcollector";
    }

    @RequestMapping("settings")
    public String settings(){
        return  "user/settings";
    }

}
