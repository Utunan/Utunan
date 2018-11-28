package com.utunan.controller.community;

import com.utunan.pojo.community.Comment;
import com.utunan.service.community.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * @author 张正扬
 * @description: 回答控制
 * @date 2018/11/22 15:53
 */
@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;



    @RequestMapping(value = "/co" ,method = RequestMethod.POST)
    public String insertComment(HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String content= request.getParameter("textarea");
        this.commentService.saveComment(content);
        Comment comment =this.commentService.getComment();
        request.setAttribute("content",comment);
        return "show";
    }
}
