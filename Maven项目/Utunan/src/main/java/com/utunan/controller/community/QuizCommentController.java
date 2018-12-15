package com.utunan.controller.community;

import com.github.pagehelper.PageInfo;
import com.utunan.pojo.base.community.*;

import com.utunan.pojo.base.user.User;
import com.utunan.pojo.inherit.community.PublishQuiz;

import com.utunan.pojo.inherit.community.BigQuiz;

import com.utunan.pojo.util.Page;
import com.utunan.service.community.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private AnswerGreatService answerGreatService;

    @Autowired
    private TagService tagService;
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
        List<Answer> answers=answerService.findAnswerListByQuizId(num,6,Long.parseLong(quizId));
        Map<Answer,List<Answer>> map=new HashMap<>();
        Map<Answer,Long>map0=new HashMap<>();


        //查询前10个评论数量的问题
        List<Quiz> quizListTop10=quizService.quizListTop10();
        //热门标签
        Object hotTagList=this.tagService.getTop10Tag();

        Answer[] a=new Answer[answers.size()];
        answers.toArray(a);
        for (int i=0;i<a.length;i++){
            //根据answerId返回子评论按时间查询
            List<Answer> childAnswerList = this.answerService.findChildAnswerListByAnswerId(a[i].getAnswerId());
            //根据answerId返回子评论数量
            Long childAnswerCount=this.answerService.findchildAnswerCount(a[i].getAnswerId());
            map.put(a[i],childAnswerList);
            map0.put(a[i],childAnswerCount);
        }



        //List<Answer> childAnswerList = this.answerService.findChildAnswerListByAnswerId(Long.parseLong(answerId));

        request.setAttribute("quizTagList", quizTagList);
        session.setAttribute("quiz", quiz);
        request.setAttribute("answerCountByQuizId", answerCountByQuizId);
        request.setAttribute("url", url);
        request.setAttribute("timeselect","selected=\"selected\"");
        request.setAttribute("answer",answers);
        request.setAttribute("map",map);
        request.setAttribute("map0",map0);
        request.setAttribute("PageInfo",new PageInfo(answers,5));
        //request.setAttribute("childAnswerList", childAnswerList);
        request.setAttribute("quizListTop10",quizListTop10);
        request.setAttribute("tag",hotTagList);
        return "community/detail";
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

        Map<Answer,List<Answer>> map=new HashMap<>();
        Map<Answer,Long>map0=new HashMap<>();


        //查询前10个评论数量的问题
        List<Quiz> quizListTop10=quizService.quizListTop10();
        //热门标签
        Object hotTagList=this.tagService.getTop10Tag();

        Answer[] a=new Answer[answers.size()];
        answers.toArray(a);
        for (int i=0;i<a.length;i++){
            //根据answerId返回子评论按热度查询
            List<Answer> childAnswerList = this.answerService.findChildAnswerListByCount(a[i].getAnswerId());
            //根据answerId返回子评论数量
            Long childAnswerCount=this.answerService.findchildAnswerCount(a[i].getAnswerId());
            map.put(a[i],childAnswerList);
            map0.put(a[i],childAnswerCount);
        }

    
        request.setAttribute("quizTagList", quizTagList);
        session.setAttribute("quiz", quiz);
        request.setAttribute("answerCountByQuizId", answerCountByQuizId);
        request.setAttribute("praiseselect","selected=\"selected\"");
        request.setAttribute("answer",answers);
        request.setAttribute("map",map);
        request.setAttribute("map0",map0);
        request.setAttribute("PageInfo",new PageInfo(answers,5));
        request.setAttribute("quizListTop10",quizListTop10);
        request.setAttribute("tag",hotTagList);
    
        return "community/detail";
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
        User user=(User)session.getAttribute("User");
        //到回答评论点赞表进行查询是否有记录
//        AnswerGreat answerGreat =answerGreatService.getAnswerGreat(Long.parseLong(answerId),user.getUserId());
//        if(answerGreat==null){
//            answerGreatService.addAnswerGreat(Long.parseLong(answerId),user.getUserId());
//            this.answerService.praiseAnswer(Long.parseLong(answerId));
//        }
//        else {
//            answerGreatService.delAnswerGreat(Long.parseLong(answerId),user.getUserId());
//            this.answerService.delPraiseAnswer(Long.parseLong(answerId));
//        }

        return "redirect:/displayQuizByQuizId?quizId="+quiz.getQuizId();
    }
}
