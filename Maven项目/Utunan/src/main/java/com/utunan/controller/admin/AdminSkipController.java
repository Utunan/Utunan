package com.utunan.controller.admin;

import com.github.pagehelper.PageInfo;
import com.utunan.pojo.base.community.Answer;
import com.utunan.pojo.base.community.Quiz;
import com.utunan.pojo.base.questionbank.Question;
import com.utunan.pojo.base.school.Direction;
import com.utunan.pojo.base.user.User;
import com.utunan.service.admin.AdminDirectionService;
import com.utunan.service.admin.AdminQuestionService;
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
    @Autowired
    private AdminDirectionService adminDirectionService;
    @Autowired
    private AdminQuestionService adminQuestionService;

    @RequestMapping("")
    public String admin(HttpServletRequest request) {
        request.setAttribute("QuizCount", 100);
        //题目数量
        request.setAttribute("QuestionCount", 100);
        //用户数(所有用户,包括管理员)
        request.setAttribute("UserCount", 100);
        //今日用户浏览次数
        request.setAttribute("BrowseCount", 100);

        return "/admin/index";
    }

    @RequestMapping("welcome")
    public String welcome() {
        return "/admin/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpSession session) {
        User user = (User) session.getAttribute("User");
        if (user == null)
            return "/admin/login";
        return "/admin/";
    }

    @RequestMapping("memberlist")
    public String meberlist(HttpSession session, HttpServletRequest request) {
        List<User> users = null;
        String pageNum = request.getParameter("pageNum");
        if (pageNum == null || pageNum == "" || Integer.parseInt(pageNum) <= 0)
            users = userService.getAllMember(1, 10);
        else
            users = userService.getAllMember(Integer.parseInt(pageNum), 10);
        request.setAttribute("PageInfo", new PageInfo(users, 5));
        session.setAttribute("Users", users);
        return "admin/user/memberlist";
    }

    @RequestMapping("memberadd")
    public String memberadd() {
        return "admin/user/memberadd";
    }

    @RequestMapping("memberedit")
    public String memberedit() {
        return "admin/user/memberedit";
    }

    @RequestMapping("directioncommentlist")
    public String directionlist(HttpServletRequest request, HttpSession session) {
        List<Direction> directions = null;
        String pageNum = request.getParameter("pageNum");
        if (pageNum == null || pageNum == "" || Integer.parseInt(pageNum) <= 0)
            directions = adminDirectionService.getAllDirection(1, 20);
        else
            directions = adminDirectionService.getAllDirection(Integer.parseInt(pageNum), 20);
        request.setAttribute("PageInfo", new PageInfo(directions, 5));
        session.setAttribute("Directions", directions);

        return "admin/direction/directioncommentlist";
    }

    @RequestMapping("adminlist")
    public String adminlist(HttpSession session, HttpServletRequest request) {
        List<User> admins = null;
        String pageNum = request.getParameter("pageNum");
        if (pageNum == null || pageNum == "" || Integer.parseInt(pageNum) <= 0)
            admins = userService.getAllAdmin(1, 10);
        else
            admins = userService.getAllAdmin(Integer.parseInt(pageNum), 10);
        request.setAttribute("PageInfo", new PageInfo(admins, 5));
        session.setAttribute("Admins", admins);
        return "admin/user/adminlist";
    }

    @RequestMapping("ConstituteQuestion")
    public String constituteQuestion(HttpServletRequest request, HttpSession session) {
        List<Question> questions = null;
        String pageNum = request.getParameter("pageNum");
        if (pageNum == null || pageNum == "" || Integer.parseInt(pageNum) <= 0)
            questions = adminQuestionService.getAllConstitute(1, 10);
        else
            questions = adminQuestionService.getAllConstitute(Integer.parseInt(pageNum), 10);
        request.setAttribute("PageInfo", new PageInfo(questions, 5));
        session.setAttribute("ConstituteQuestions", questions);
        return "admin/question/ConstituteQuestion";
    }

    @RequestMapping("CQuestion")
    public String questionC(HttpServletRequest request, HttpSession session) {
        List<Question> questions = null;
        String pageNum = request.getParameter("pageNum");
        if (pageNum == null || pageNum == "" || Integer.parseInt(pageNum) <= 0)
            questions = adminQuestionService.getAllC(1, 10);
        else
            questions = adminQuestionService.getAllC(Integer.parseInt(pageNum), 10);
        request.setAttribute("PageInfo", new PageInfo(questions, 5));
        session.setAttribute("CQuestions", questions);
        return "admin/question/CQuestion";
    }

    @RequestMapping("DSQuestion")
    public String questionDS(HttpServletRequest request, HttpSession session) {
        List<Question> questions = null;
        String pageNum = request.getParameter("pageNum");
        if (pageNum == null || pageNum == "" || Integer.parseInt(pageNum) <= 0)
            questions = adminQuestionService.getAllDS(1, 10);
        else
            questions = adminQuestionService.getAllDS(Integer.parseInt(pageNum), 10);
        request.setAttribute("PageInfo", new PageInfo(questions, 5));
        session.setAttribute("DSQuestions", questions);
        return "admin/question/DSQuestion";
    }

    @RequestMapping("NetworkQuestion")
    public String NetworkQuestion(HttpSession session, HttpServletRequest request) {
        List<Question> questions = null;
        String pageNum = request.getParameter("pageNum");
        if (pageNum == null || pageNum == "" || Integer.parseInt(pageNum) <= 0)
            questions = adminQuestionService.getAllNetwork(1, 10);
        else
            questions = adminQuestionService.getAllNetwork(Integer.parseInt(pageNum), 10);
        request.setAttribute("PageInfo", new PageInfo(questions, 5));
        session.setAttribute("NetworkQuestions", questions);
        return "admin/question/NetworkQuestion";
    }

    @RequestMapping("OSQuestion")
    public String OSQuestion(HttpServletRequest request,HttpSession session){
        List<Question> questions = null;
        String pageNum = request.getParameter("pageNum");
        if (pageNum == null || pageNum == "" || Integer.parseInt(pageNum) <= 0)
            questions = adminQuestionService.getAllDS(1, 10);
        else
            questions = adminQuestionService.getAllDS(Integer.parseInt(pageNum), 10);
        request.setAttribute("PageInfo", new PageInfo(questions, 5));
        session.setAttribute("OSQuestions", questions);
        return "admin/question/OSQuestion";
    }

    @RequestMapping("SEQuestion")
    public String SEQuestion(HttpSession session,HttpServletRequest request){
        List<Question> questions = null;
        String pageNum = request.getParameter("pageNum");
        if (pageNum == null || pageNum == "" || Integer.parseInt(pageNum) <= 0)
            questions = adminQuestionService.getAllSE(1, 10);
        else
            questions = adminQuestionService.getAllSE(Integer.parseInt(pageNum), 10);
        request.setAttribute("PageInfo", new PageInfo(questions, 5));
        session.setAttribute("SEQuestions", questions);
        return "admin/question/SEQuestion";
    }

    @RequestMapping("quizlist")
    public String quizlist(){
        List<Quiz> quizzes=null;

        return "admin/quiz/quizlist";
    }
    @RequestMapping("answerlist")
    public String commentlist(){
        List<Answer> answers=null;

        return "admin/quiz/answerlist";
    }

}
