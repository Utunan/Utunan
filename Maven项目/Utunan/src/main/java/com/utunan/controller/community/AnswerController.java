package com.utunan.controller.community;

import com.utunan.pojo.base.community.Quiz;
import com.utunan.pojo.base.user.User;
import com.utunan.service.community.AnswerService;
import com.utunan.service.community.QuizService;
import com.utunan.service.user.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

/**
 * @author 张正扬
 * @description: 回答控制
 * @date 2018/11/22 15:53
 */
@Controller
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    @Autowired
    private QuizService quizService;
    @Autowired
    private MessageService messageService;


    /*
     * @author  张正扬
     * @description 将回答插入数据库
     * @date  9:49 2018/11/28
     * @param  [request, session]
     * @return  java.lang.String
     */
    @RequestMapping(value = "/answer", method = RequestMethod.POST)
    public String insertComment(HttpServletRequest request, HttpSession session) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        Quiz quiz=(Quiz)session.getAttribute("quiz");
        Long quizId=Long.parseLong(request.getParameter("quizId"));
        String content = request.getParameter("textarea");
        User user = (User)session.getAttribute("User");

        //封装message表中内容
        String messageContent="<a _href='/quiz/'"+quizId+">"+quiz.getQuizTitle()+"</a>";
        Long mid=messageService.getMaxMid();
        mid+=1;
        this.quizService.addAnswerCount(quizId);
        Long aid = this.answerService.getMaxAid();
        aid += 1;
        if (user != null) {

            this.answerService.saveAnswer(aid, quiz, content, user);
            this.messageService.saveMessage(mid,quiz.getUser(),user,quizId,"2",messageContent,"0");

        }
        return "redirect:/quiz/"+quizId;
    }


    @RequestMapping(value = "/answer1", method = RequestMethod.POST)
    /*
     * @author  张正扬
     * @description 向评论表中插入评论
     * @date  20:48 2018/11/29
     * @param  [request, session]
     * @return  java.lang.String
     */
    public String insertComment1(HttpServletRequest request, HttpSession session) throws
            UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String answerId = request.getParameter("answerId");
        String content = request.getParameter("text");
        Object ob = session.getAttribute("User");
        Long aid = this.answerService.getMaxAid();
        aid += 1;
        if (ob != null) {
            User user = (User) ob;


            this.answerService.saveAnswer1(aid, Long.parseLong(answerId), content, user);



        }
        return "redirect:/displayChildAnswer?answerId=" + answerId;
    }
}
