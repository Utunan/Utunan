package com.utunan.controller.community;

import com.utunan.pojo.base.community.Quiz;
import com.utunan.pojo.base.user.QuizCollector;
import com.utunan.pojo.base.user.User;
import com.utunan.service.community.QuizCollectService;
import com.utunan.service.user.QuizCollectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author 张正扬
 * @description: TODO
 * @date 2018/12/5 20:26
 */
@Controller
public class CollectorController {

    @Autowired
    private QuizCollectService quizCollectService;

    @RequestMapping(value = "quizCollector")
    public String quizCollector(HttpServletRequest request,HttpSession session){
        String quizId=request.getParameter("quizId");
        Quiz quiz=(Quiz)session.getAttribute("quiz");

        User user1=(User)session.getAttribute("User");
        System.out.print(user1);
        Long qcid=quizCollectService.getMaxQCid();
        qcid+=1;


        this.quizCollectService.insertQuizCollector(qcid,user1, quiz);
        return "redirect:/displayQuizByQuizId?quizId=" + quizId;


    }
}
