package com.utunan.controller.user;

import com.utunan.pojo.base.user.User;
import com.utunan.service.user.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserDeleteController {

    @Autowired
    private UserCollectorDeleteService userCollectorDeleteService;
    @Autowired
    private UserService userService;

    @RequestMapping("/questioncollector/{questionId}")
    public String deleteQuestionCollector(HttpServletRequest request, @PathVariable String questionId) {
        User user = (User) request.getSession().getAttribute("User");

        userCollectorDeleteService.deleteQuestionCollector(user.getUserId(), questionId);
        return "redirect:/user/questioncollector";
    }

    @RequestMapping("/quizcollector/{quizId}")
    public String deleteQuizCollector(HttpServletRequest request, @PathVariable String quizId) {
        User user = (User) request.getSession().getAttribute("User");
        userCollectorDeleteService.deleteQuizCollector(user.getUserId(), quizId);
        return "redirect:/user/quizcollector";
    }

    @RequestMapping("/directioncollector/{directionId}")
    public String deleteDirectionCollector(HttpServletRequest request, @PathVariable String directionId) {
        User user = (User) request.getSession().getAttribute("User");
        userCollectorDeleteService.deleteDirectionCollector(user.getUserId(), directionId);
        return "redirect:/user/directioncollector";
    }

    @RequestMapping("/cancel")
    @ResponseBody
    public String cancelFollow(HttpServletRequest request) {
        try {
            String followedId = request.getParameter("followedId");
            System.out.println(followedId);
            User user = (User) request.getSession().getAttribute("User");
            userService.cancelFollow(Long.parseLong(followedId), user.getUserId());
            return "{\"state\":\"success\"}";
        }catch(Exception e){
            return "{\"state\":\"unsuccess\"}";
        }
    }
}
