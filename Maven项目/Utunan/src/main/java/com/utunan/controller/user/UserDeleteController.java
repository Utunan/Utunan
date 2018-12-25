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
    @ResponseBody
    public String deleteQuestionCollector(HttpServletRequest request, @PathVariable String questionId) {
        try {
            User user = (User) request.getSession().getAttribute("User");

            userCollectorDeleteService.deleteQuestionCollector(user.getUserId(), questionId);
            return "{\"state\":\"success\"}";
        } catch (Exception e) {
            return "{\"state\":\"unsuccess\"}";
        }
    }

    @RequestMapping("/quizcollector/{quizId}")
    @ResponseBody
    public String deleteQuizCollector(HttpServletRequest request, @PathVariable String quizId) {
        try {
            User user = (User) request.getSession().getAttribute("User");
            userCollectorDeleteService.deleteQuizCollector(user.getUserId(), quizId);
            return "{\"state\":\"success\"}";
        } catch (Exception e) {
            return "{\"state\":\"unsuccess\"}";
        }
    }

    @RequestMapping("/directioncollector/{directionId}")
    @ResponseBody
    public String deleteDirectionCollector(HttpServletRequest request, @PathVariable String directionId) {
        try {
            User user = (User) request.getSession().getAttribute("User");
            userCollectorDeleteService.deleteDirectionCollector(user.getUserId(), directionId);
            return "{\"state\":\"success\"}";
        } catch (
                Exception e) {
            return "{\"state\":\"unsuccess\"}";
        }

    }


}
