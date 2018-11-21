package com.utunan.controller.community;

import com.utunan.pojo.community.Quiz;
import com.utunan.pojo.community.Tag;
import com.utunan.pojo.util.Page;
import com.utunan.service.community.QuizService;
import com.utunan.service.community.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
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
	@Autowired
	private TagService tagService;

	@RequestMapping(value="/quiz1")
	public String displayQuizByTime(HttpServletRequest request){
		String url="quiz1";
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
		//热门标签
		List<Tag> name=this.tagService.getTop10Tag();
		//热门标签的回答数量
		List<Long> number=this.tagService.getTop10TagNumber();

		Object[][] tag=new Object[10][2];
		for(int i=0; i<name.size(); i++){
			tag[i][0]=name.get(i);
			tag[i][1]=number.get(i);
		}

		Page<Quiz> p = new Page<Quiz>(num, 6);
		p.setList(list);
		p.setTotalCount(count);

		request.setAttribute("page",p);
		request.setAttribute("url",url);
		request.setAttribute("tag",tag);
		return "community/quiz";
	}

	/**
	 * @author  孙程程
	 * @description 根据点赞数量展示问答列表
	 * @date  17:52 2018/11/20
	 * @param  "[request]
	 * @return  java.lang.String
	 */
	@RequestMapping(value="/quiz2")
	public String displayQuizByPraise(HttpServletRequest request){
		String url="quiz2";
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
		//问题数量
		Long count = this.quizService.countAllQuiz();
		//热门标签
		List<Tag> name=this.tagService.getTop10Tag();
		//热门标签的回答数量
		List<Long> number=this.tagService.getTop10TagNumber();

		Object[][] tag=new Object[10][2];
		for(int i=0; i<name.size(); i++){
			tag[i][0]=name.get(i);
			tag[i][1]=number.get(i);
		}

		Page<Quiz> p = new Page<Quiz>(num, 6);
		p.setList(list);
		p.setTotalCount(count);

		request.setAttribute("page",p);
		request.setAttribute("url",url);
		request.setAttribute("tag",tag);
		return "community/quiz";
	}

}
