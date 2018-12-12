package com.utunan.controller.community;

import com.alibaba.druid.sql.visitor.functions.If;
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
public class QuizCollectorController {

    @Autowired
    private QuizCollectService quizCollectService;

    @RequestMapping(value = "quizCollector")
    public String quizCollector(HttpServletRequest request,HttpSession session){
    String quizId=request.getParameter("quizId");
    Quiz quiz=(Quiz)session.getAttribute("quiz");

        User user1=(User)session.getAttribute("User");
        Long qcid=quizCollectService.getMaxQCid();
        qcid+=1;
        //判断用户是否点赞
        QuizCollector quizCollector=this.quizCollectService.getQuizCollector(Long.parseLong(quizId),user1.getUserId());
        if(quizCollector==null) {
            this.quizCollectService.insertQuizCollector(qcid, user1, quiz);
        }
        else {
            this.quizCollectService.delQuizCollector(Long.parseLong(quizId),user1.getUserId());
        }
        return "redirect:/displayQuizByQuizId?quizId=" + quizId;


    }
}
