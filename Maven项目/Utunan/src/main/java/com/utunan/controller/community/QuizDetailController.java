package com.utunan.controller.community;

import com.github.pagehelper.PageInfo;
import com.utunan.pojo.base.community.*;

import com.utunan.pojo.base.user.User;
import com.utunan.pojo.inherit.community.PublishQuiz;

import com.utunan.pojo.inherit.community.BigQuiz;

import com.utunan.pojo.util.Page;
import com.utunan.service.community.*;
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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.utunan.pojo.base.questionbank.QuestionLog;
import java.util.ArrayList;
/**
 * @author 王碧云
 * @description: 问题页面控制
 * @date 2018/11/24 16:44
 */
@Controller
public class QuizDetailController {

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
    @Autowired
    private QuizGreatService quizGreatService;

    @Autowired
    private QuizCollectService quizCollectService;
    /*
     * @author  王碧云
     * @description 返回对应QuizId对应的问题页面的值(默认按照时间排序)(分页)
     * @date  12:50 2018/11/25/025
     * @param  [request]
     * @return  java.lang.String
     */
    @RequestMapping("/quiz/{quizId}")
    public String displayQuizByQuizId(@PathVariable String quizId, HttpServletRequest request, HttpSession session){

        String url = "quiz/{quizId}";
        //获取页数
        String pageNum=request.getParameter("pageNum");
        //判断当前页
        int num=0;
        if(pageNum==null || pageNum.equals("")){
            num=1;
        }else{
            num=Integer.parseInt(pageNum);
        }
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
        //获取用户
        User user = (User) session.getAttribute("User");
        Long userId = null;
        if(user != null){
            //用户已登录
            userId = user.getUserId();
        }
        //添加 日志
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time =df.format(new Date());
        QuestionLog log1=new QuestionLog();
        log1.setQuizId(Long.parseLong(quizId));
        log1.setUserId(userId);
        log1.setTime(time);
        log1.logsth();
        //查询前10个评论数量最高的问题
        List<Quiz> quizListTop10=quizService.quizListTop10();
        String s ="D:\\Python\\test.txt";
        List quizListTop= new ArrayList();
        List itemList = new ArrayList();
        try {
            String[] args1 = new String[] { "python", "D:\\Python\\test.py", String.valueOf(s),String.valueOf(userId)};
            Process proc = Runtime.getRuntime().exec(args1);// 执行py文件
            //用输入输出流来截取结果
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String  line = null;
            while ((line =in.readLine()) != null) {
                System.out.println(line);
                itemList.add(line);
            }

            in.close();
            proc.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(itemList.get(0));
        for(int i=0;i<itemList.size();i++){
            Quiz quizRecomm =this.quizService.findQuizById(Long.parseLong(itemList.get(i).toString()));
            System.out.println(quizRecomm );
            quizListTop.add(quizRecomm);
        }

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


        //判断用户是否点赞过该问题
        QuizGreat qg = this.quizGreatService.getQuizGreat(Long.parseLong(quizId), userId);
        //获取用户在该问题的点赞评论列表
        List<Long> answerGreatList = this.answerGreatService.getAGList(userId);

        //查询收藏的quiz
        List<Long> quizIds=this.quizCollectService.getAllQuizId(userId);
        request.setAttribute("quizTagList", quizTagList);
        session.setAttribute("quiz", quiz);
        request.setAttribute("answerCountByQuizId", answerCountByQuizId);
        request.setAttribute("url", url);
        request.setAttribute("timeselect","selected=\"selected\"");
        request.setAttribute("answer",answers);
        request.setAttribute("map",map);
        request.setAttribute("map0",map0);
        request.setAttribute("PageInfo",new PageInfo(answers,5));
//        request.setAttribute("quizListTop10",quizListTop10);
        request.setAttribute("quizListTop10",quizListTop);
        request.setAttribute("tag",hotTagList);
        request.setAttribute("quizIds",quizIds);
        request.setAttribute("user", user);
        request.setAttribute("quizGreat", qg);
        request.setAttribute("answerGreatList", answerGreatList);


        return "community/detail";
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

        //获取用户
        User user = (User) session.getAttribute("User");
        Long userId = null;
        if(user != null){
            //用户已登录
            userId = user.getUserId();
        }

        //查询收藏的quiz
        List<Long> quizIds=this.quizCollectService.getAllQuizId(userId);
        //判断用户是否点赞过该问题
        QuizGreat qg = this.quizGreatService.getQuizGreat(Long.parseLong(quizId), userId);
        //获取用户在该问题的点赞评论列表
        List<Long> answerGreatList = this.answerGreatService.getAGList(userId);
    
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
        request.setAttribute("quizIds",quizIds);
        request.setAttribute("user", user);
        request.setAttribute("quizGreat", qg);
        request.setAttribute("answerGreatList", answerGreatList);
    
        return "community/detail";
    }


    /*
     * @author  张正扬
     * @description 给回答点赞
     * @date  21:26 2018/11/27
     * @param  request
     * @return  String
     */
    @ResponseBody
    @RequestMapping("/aprise")
    public void praiseQuiz(HttpServletRequest request, HttpSession session, HttpServletResponse response) throws IOException {
        String answerId=request.getParameter("answerId");
        User user=(User)session.getAttribute("User");
        //创建JSON
        JSONObject obj=new JSONObject();
        //到回答评论点赞表进行查询是否有记录
        AnswerGreat answerGreat =answerGreatService.getAnswerGreat(Long.parseLong(answerId),user.getUserId());
        if(answerGreat==null){
            //可以点赞
            answerGreatService.addAnswerGreat(Long.parseLong(answerId),user.getUserId());
            this.answerService.praiseAnswer(Long.parseLong(answerId));
            //查找当前点赞数
            Long answerPraiseCount = this.answerService.getAnswer(Long.parseLong(answerId)).getPraiseCount();
            //加入json
            obj.put("res", "ok");
            obj.put("answerPraiseCount", answerPraiseCount);
            //返回数据
            response.getWriter().append(obj.toString());
        }
        else {
            //取消点赞
            answerGreatService.delAnswerGreat(Long.parseLong(answerId),user.getUserId());
            this.answerService.delPraiseAnswer(Long.parseLong(answerId));
            //查找当前点赞数
            Long answerPraiseCount = this.answerService.getAnswer(Long.parseLong(answerId)).getPraiseCount();
            //加入json
            obj.put("res", "no");
            obj.put("answerPraiseCount", answerPraiseCount);
            //返回数据
            response.getWriter().append(obj.toString());
        }
    }


    /**
     * 登录用户删除提问
     */

    @RequestMapping("/delquiz/{quizId}")
    public String delQuiz(@PathVariable String quizId, HttpServletRequest request, HttpServletResponse response){
        //根据quizId删除提问及回答评论
        this.quizService.delQuiz(Long.parseLong(quizId));
        return "redirect:/quizs/rt/1";
    }

    /**
     * 登录用户删除回答
     */

    @RequestMapping(value = "/delanswer/{answerId}",method = RequestMethod.GET)
    @ResponseBody
    public void delAnswer(@PathVariable String answerId,HttpServletRequest request,HttpServletResponse response) throws IOException {

        Long quizId=Long.parseLong(request.getParameter("quizId"));
        //创建JSON
        JSONObject obj=new JSONObject();
        //根据answerId删除回答及评论
        this.answerService.delAnswer(Long.parseLong(answerId));
        //查询当前回答总数
        Long totalcount=this.answerService.gettal(quizId);
        obj.put("count1",totalcount);
        obj.put("res","ok");
        response.getWriter().append(obj.toString());
    }

    /**
     * 登录用户删除评论
     */
    @RequestMapping(value = "/delcomment/{answerId}/{parentanswerId}",method = RequestMethod.GET)
    @ResponseBody
    public void delComment(@PathVariable String answerId,@PathVariable String parentanswerId,HttpServletResponse response) throws IOException {
        //创建JSON
        JSONObject obj=new JSONObject();
        //登录用户删除评论
        this.answerService.delComment(Long.parseLong(answerId),Long.parseLong(parentanswerId));
        //查询当前评论总数
        Long totalcount=this.answerService.findchildAnswerCount(Long.parseLong(parentanswerId));
        obj.put("res","ok");
        obj.put("count2",totalcount);
        response.getWriter().append(obj.toString());
    }
}
