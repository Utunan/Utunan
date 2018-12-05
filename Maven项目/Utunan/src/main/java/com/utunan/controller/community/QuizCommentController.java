package com.utunan.controller.community;

import com.github.pagehelper.PageInfo;
import com.utunan.pojo.base.community.Answer;
import com.utunan.pojo.base.community.Quiz;
import com.utunan.pojo.base.community.QuizTag;

import com.utunan.pojo.inherit.community.PublishQuiz;

import com.utunan.pojo.inherit.community.BigQuiz;

import com.utunan.pojo.util.Page;
import com.utunan.service.community.AnswerService;
import com.utunan.service.community.PublishQuizService;
import com.utunan.service.community.QuizService;
import com.utunan.service.community.QuizTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 王碧云
 * @description: 问题页面控制
 * @date 2018/11/24 16:44
 */
@Controller
public class QuizCommentController {

    @Autowired
    private QuizService quizService;
    @Autowired
    private QuizTagService quizTagService;
    @Autowired
    private AnswerService answerService;

    @Autowired
    private PublishQuizService publishQuizService;
    /*
     * @author  王碧云
     * @description 返回对应QuizId对应的问题页面的值(默认按照时间排序)(分页)
     * @date  12:50 2018/11/25/025
     * @param  [request]
     * @return  java.lang.String
     */
    @RequestMapping("/displayQuizByQuizId")
    public String displayQuizByQuizId(HttpServletRequest request, HttpSession session){
        String url = "displayQuizByQuizId";
        //获取页数
        String pageNum=request.getParameter("pageNum");
        //判断当前页
        int num=0;
        if(pageNum==null || pageNum.equals("")){
            num=1;
        }else{
            num=Integer.parseInt(pageNum);
        }

        String quizId = request.getParameter("quizId");
        //根据quizId返回quiz
        Quiz quiz = this.quizService.findQuizById(Long.parseLong(quizId));
        //根据quizId返回标签
        List<QuizTag> quizTagList =this.quizTagService.findQuizTagByQuizId(Long.parseLong(quizId));
        //根据quizId返回评论数量
        Long answerCountByQuizId = this.publishQuizService.countAnswerByQuizId(Long.parseLong(quizId));
        //根据quizId返回评论列表(根据时间排序)
        List<Answer> answers=answerService.findAnswerListByQuizId(num,5,Long.parseLong(quizId));

        //根据commentId返回子评论
        //List<Answer> childAnswerList = this.answerService.findChildAnswerListByAnswerId(Long.parseLong(answerId));

        request.setAttribute("quizTagList", quizTagList);
        session.setAttribute("quiz", quiz);
        request.setAttribute("answerCountByQuizId", answerCountByQuizId);
        request.setAttribute("url", url);
        request.setAttribute("timeselect","selected=\"selected\"");
        request.setAttribute("answer",answers);
        request.setAttribute("PageInfo",new PageInfo(answers,5));
        //request.setAttribute("childAnswerList", childAnswerList);

    
        return "community/quizcommentpage";
    }
    
    /*
     * @author  王碧云
     * @description 跳转返回子评论
     * @date  21:23 2018/11/25/025
     * @param  [request]
     * @return  java.lang.String
     */
    @RequestMapping("/displayChildAnswer")
    public String displayChildComment(HttpServletRequest request){
        String answerId = request.getParameter("answerId");
        //根据commentId返回子评论
        List<Answer> childAnswerList = this.answerService.findChildAnswerListByAnswerId(Long.parseLong(answerId));
    
        request.setAttribute("childAnswerList", childAnswerList);
        System.out.println("[childAnswer]"+ childAnswerList);
    
        return "community/childcomment";
    }
    
    /*
     * @author  王碧云 
     * @description 评论根据热度排序
     * @date  10:59 2018/11/26/026 
     * @param  [request]
     * @return  java.lang.String
     */
    @RequestMapping("/displayCommentByPraiseCount")
    public String displayCommentByPraiseCount(HttpServletRequest request,HttpSession session){
        //获取页数
        String pageNum=request.getParameter("pageNum");
        //判断当前页
        int num=0;
        if(pageNum==null || pageNum.equals("")){
            num=1;
        }else{
            num=Integer.parseInt(pageNum);
        }
        String quizId = request.getParameter("quizId");
        //根据quizId返回quiz
        Quiz quiz = this.quizService.findQuizById(Long.parseLong(quizId));
        //根据quizId返回标签
        List<QuizTag> quizTagList =this.quizTagService.findQuizTagByQuizId(Long.parseLong(quizId));
        //根据quizId返回评论数量
        Long answerCountByQuizId = this.publishQuizService.countAnswerByQuizId(Long.parseLong(quizId));
        //根据quizId返回评论列表(根据热度排序)
        List<Answer> answers = this.answerService.findAnswerListByPraiseCount(num,6,Long.parseLong(quizId));

    
        request.setAttribute("quizTagList", quizTagList);
        session.setAttribute("quiz", quiz);
        request.setAttribute("answerCountByQuizId", answerCountByQuizId);
        request.setAttribute("praiseselect","selected=\"selected\"");
        request.setAttribute("answer",answers);
        request.setAttribute("PageInfo",new PageInfo(answers,5));
    
        return "community/quizcommentpage";
    }


    /*
     * @author  张正扬
     * @description 给回答点赞
     * @date  21:26 2018/11/27
     * @param  request
     * @return  String
     */
    @RequestMapping(value = "/aprise")
    public String praiseQuiz(HttpServletRequest request,HttpSession session){
        String answerId=request.getParameter("answerId");
        Quiz quiz=(Quiz)session.getAttribute("quiz");
        Long num=Long.parseLong(answerId);
        this.answerService.praiseAnswer(num);
        return "redirect:/displayQuizByQuizId?quizId="+quiz.getQuizId();
    }
}
