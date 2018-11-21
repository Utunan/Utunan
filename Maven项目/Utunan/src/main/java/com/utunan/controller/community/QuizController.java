package com.utunan.controller.community;

import com.utunan.pojo.community.Quiz;
import com.utunan.pojo.user.User;
import com.utunan.pojo.util.Page;
import com.utunan.service.community.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author 孙程程
 * @description: 问答首页
 * @date 2018/11/19 16:24
 */
@Controller
public class QuizController {

	@Autowired
	private QuizService quizService;

	/**
	 * @author  孙程程
	 * @description 根据时间顺序展示问答列表
	 * @date  20:15 2018/11/19
<<<<<<< HEAD
	 * @param
=======
	 * @param  "[request]
>>>>>>> 14916c981f54891d90e83fbe769c073f55a1221e
	 * @return  java.lang.String
	 */
	@RequestMapping(value="/quiz1")
	public String displayQuizByTime(HttpServletRequest request){
		String pageNum=request.getParameter("pageNum");
		//判断当前页
		int num=0;
		if(pageNum==null || pageNum.equals("")){
			num=1;
		}else{
			num=Integer.parseInt(pageNum);
		}
		//问答列表
		List<Quiz> list=this.quizService.getQuizByTime(num,6);
		//问答数量
		Long count = this.quizService.countAllQuiz();

		Page<Quiz> p = new Page<Quiz>(num, 6);
		p.setList(list);
		p.setTotalCount(count);
		System.out.println("pageNum:"+pageNum);
		System.out.println(list);
		System.out.println(count);
		request.setAttribute("page",p);
		return "quiz";
	}

	/**
	 * @author  孙程程
	 * @description 根据点赞数量展示问答列表
	 * @date  17:52 2018/11/20
	 * @param  [request]
	 * @return  java.lang.String
	 */
	@RequestMapping(value="/quiz2")
	public String displayQuizByPraise(HttpServletRequest request){
		String pageNum=request.getParameter("pageNum");
		//判断当前页
		int num=0;
		if(pageNum==null || pageNum.equals("")){
			num=1;
		}else{
			num=Integer.parseInt(pageNum);
		}
		//问答列表
		List<Quiz> list=this.quizService.getQuizByPraise(num,6);
		//问答数量
		Long count = this.quizService.countAllQuiz();

		Page<Quiz> p = new Page<Quiz>(num, 6);
		p.setList(list);
		p.setTotalCount(count);
		System.out.println("pageNum:"+pageNum);
		System.out.println(list);
		System.out.println(count);
		request.setAttribute("page",p);
		return "WEB-INF/view/quiz";
	}
	/*
	 * @author  张正扬
	 * @description
	 * @date  13:24 2018/11/21
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/quiz3",method = RequestMethod.POST)
	public String quizeInsert(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		String title=request.getParameter("title");
		int num=Integer.parseInt(request.getParameter("j1"));
		String content= request.getParameter("textarea");
		this.quizService.saveQuiz(title,content);
		Quiz quiz=this.quizService.getQuiz(title,content);

		request.setAttribute("content",content);
		return "show.jsp";
	}

}
