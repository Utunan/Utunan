package com.utunan.controller.community;

import com.utunan.pojo.community.Quiz;
import com.utunan.service.community.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 王碧云
 * @description: TODO
 * @date 2018/11/24 16:44
 */
@Controller
public class QuizCommentController {

    @Autowired
    private QuizService quizService;

    @RequestMapping("/displayQuizByQuizId")
    public String displayQuizByQuizId(HttpServletRequest request){
        String quizId = request.getParameter("quizId");
        Quiz quiz = this.quizService.findQuizById(Integer.parseInt(quizId));
        request.setAttribute("quiz", quiz);
        System.out.println("[quiz:]"+quiz);
        return "community/quizcommentpage";
    }
}
