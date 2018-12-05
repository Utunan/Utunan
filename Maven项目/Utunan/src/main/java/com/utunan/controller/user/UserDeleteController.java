package com.utunan.controller.user;

import com.utunan.pojo.base.user.User;
import com.utunan.service.user.DirectionCollectorService;
import com.utunan.service.user.QuestionCollectorService;
import com.utunan.service.user.QuizCollectorService;
import com.utunan.service.user.UserCollectorDeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserDeleteController {

    @Autowired
    private UserCollectorDeleteService userCollectorDeleteService;

    @RequestMapping("/questioncollector/{questionId}")
    public String deleteQuestionCollector(HttpServletRequest request, @PathVariable String questionId){
        User user=(User)request.getSession().getAttribute("User");

        userCollectorDeleteService.deleteQuestionCollector(user.getUserId(),questionId);
        return "redirect:/user/questioncollector";
    }
    @RequestMapping("/quizcollector/{quizId}")
    public String deleteQuizCollector(HttpServletRequest request,@PathVariable String quizId){
        User user=(User)request.getSession().getAttribute("User");
        userCollectorDeleteService.deleteQuizCollector(user.getUserId(),quizId);
        return "redirect:/user/quizcollector";
    }
    @RequestMapping("/directioncollector/{directionId}")
    public String deleteDirectionCollector(HttpServletRequest request,@PathVariable String directionId){
        User user=(User)request.getSession().getAttribute("User");
        userCollectorDeleteService.deleteDirectionCollector(user.getUserId(),directionId);
        return "redirect:/user/directioncollector";
    }
}
