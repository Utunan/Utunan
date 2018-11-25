package com.utunan.controller.community;

import com.utunan.pojo.community.Comment;
import com.utunan.pojo.community.Quiz;
import com.utunan.pojo.community.QuizTag;
import com.utunan.service.community.CommentService;
import com.utunan.service.community.QuizService;
import com.utunan.service.community.QuizTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
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
    private CommentService commentService;
    /*
     * @author  王碧云
     * @description 返回对应QuizId对应的问题页面的值
     * @date  12:50 2018/11/25/025
     * @param  [request]
     * @return  java.lang.String
     */
    @RequestMapping("/displayQuizByQuizId")
    public String displayQuizByQuizId(HttpServletRequest request){
        String quizId = request.getParameter("quizId");
        //根据quizId返回quiz
        Quiz quiz = this.quizService.findQuizById(Long.parseLong(quizId));
        //根据quizId返回标签
        List<QuizTag> quizTagList =this.quizTagService.findQuizTagByQuizId(Long.parseLong(quizId));
        //根据quizId返回评论数量
        Long commentCountByQuizId = this.quizService.countCommentByQuizId(Long.parseLong(quizId));
        //根据quizId返回评论列表
        List<Comment> commentListByQuizId = this.commentService.findCommentListByQuizId(Long.parseLong(quizId));

        request.setAttribute("quizTagList", quizTagList);
        request.setAttribute("quiz", quiz);
        request.setAttribute("commentCountByQuizId", commentCountByQuizId);
        request.setAttribute("commentListByQuizId", commentListByQuizId);

        System.out.println("[commentList]"+commentListByQuizId);
        System.out.println("user"+commentListByQuizId.get(1).getUser());
        return "community/quizcommentpage";
    }

    public String displayChildComment(){
        return
    }
}
