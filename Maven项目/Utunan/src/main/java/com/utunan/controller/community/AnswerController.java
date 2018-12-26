package com.utunan.controller.community;

import com.utunan.pojo.base.community.Answer;
import com.utunan.pojo.base.community.Quiz;
import com.utunan.pojo.base.user.User;
import com.utunan.service.community.AnswerService;
import com.utunan.service.community.QuizService;
import com.utunan.service.user.MessageService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
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
        System.out.print(quizId);
        String content = request.getParameter("textarea");
        User user = (User)session.getAttribute("User");
        //封装message表中内容
        String messageContent="<a _href='/quiz/"+quizId+"'>"+quiz.getQuizTitle()+"</a>";
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


    @ResponseBody
    @RequestMapping(value = "/answer1/{answerId}/{quizId}", method = RequestMethod.POST)
    /*
     * @author  张正扬
     * @description 向answer表中插入评论
     * @date  20:48 2018/11/29
     * @param  [request, session]
     * @return  java.lang.String
     */
    public void insertComment1(@PathVariable String quizId,@PathVariable String answerId, HttpServletRequest request, HttpSession session, HttpServletResponse response) throws
            IOException {
        //创建JSON
        JSONObject obj=new JSONObject();
        request.setCharacterEncoding("UTF-8");
        String content = request.getParameter("text");
        Object ob = session.getAttribute("User");
        Long aid = this.answerService.getMaxAid();
        aid += 1;
        if (ob != null) {
            User user = (User) ob;
            //根据answerId查询相应回答
            Answer ans=this.answerService.getAnswer(Long.parseLong(answerId));
            this.answerService.saveAnswer1(aid,Long.parseLong(quizId), Long.parseLong(answerId), content, user);
            //查询刚插入的评论信息
            Answer a=this.answerService.getAnswer(aid);
            //封装message表中内容
            String messageContent="<a _href='/quiz/"+quizId+"'>"+a.getUser().getUserNickName()+"</a>回复了你";
            Long mid=messageService.getMaxMid();
            mid+=1;
            this.messageService.saveMessage(mid,ans.getUser(),user,Long.parseLong(quizId),"2",messageContent,"0");

            //查询当前评论总数
            Long totalcount=this.answerService.findchildAnswerCount(Long.parseLong(answerId));
            obj.put("reb",a);
            obj.put("count3",totalcount);

            response.getWriter().append(obj.toString());
        }

    }
}
