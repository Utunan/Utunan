package com.utunan.controller.community;

import com.utunan.pojo.community.Quiz;
import com.utunan.pojo.community.Tag;
import com.utunan.pojo.user.User;
import com.utunan.pojo.util.BigQuiz;
import com.utunan.pojo.util.Page;
import com.utunan.service.community.QuizService;
import com.utunan.service.community.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Controller
public class QuizController {

	@Autowired
	private QuizService quizService;
	@Autowired
	private TagService tagService;

	/**
	 * @author  孙程程
	 * @description 根据发表时间展示问答列表
	 * @date  17:52 2018/11/20
	 * @param  request
	 * @return  java.lang.String
	 */
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

		//提问列表
		List<BigQuiz> objects=this.quizService.quizListByTime(num,6);
		//提问数量
		Long quizNumber = this.quizService.countAllQuiz();

		//热门标签
		List<Tag> hotTagList=this.tagService.getTop10Tag();
		//热门标签的回答数量
		List<Long> hotTagNumber=this.tagService.getTop10TagNumber();
		//封装热门标签和标签数量
		Object[][] tag=new Object[10][2];
		for(int i=0; i<hotTagList.size(); i++){
			tag[i][0]=hotTagList.get(i);
			tag[i][1]=hotTagNumber.get(i);
		}
		//封装分页
		Page<BigQuiz> p = new Page<>(num, 6);
		p.setList(objects);
		p.setTotalCount(quizNumber);

		//提问区获取问题数量查询前3个热门标签
		List<Tag> tagList3=this.tagService.getTop3Tag();

		//提问区获取余下标签
		List<Tag> getAllTag=this.tagService.getRemianTags(tagList3);
		//返回数据
		request.setAttribute("page",p);
		request.setAttribute("url",url);
		request.setAttribute("tag",tag);
		request.setAttribute("objects",objects);
		request.setAttribute("tags",tagList3);
		request.setAttribute("alltag",getAllTag);
		return "community/quiz";
	}

	/**
	 * @author  孙程程
	 * @description 根据点赞数量展示问答列表
	 * @date  17:52 2018/11/20
	 * @param  request
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
		//提问列表
		List<BigQuiz> objects=this.quizService.quizListByPraise(num,6);
		//问题数量
		Long quizNumber = this.quizService.countAllQuiz();

		//热门标签
		List<Tag> hotTagList=this.tagService.getTop10Tag();
		//热门标签的回答数量
		List<Long> hotTagNumber=this.tagService.getTop10TagNumber();
		//封装热门标签和标签数量
		Object[][] tag=new Object[10][2];
		for(int i=0; i<hotTagList.size(); i++){
			tag[i][0]=hotTagList.get(i);
			tag[i][1]=hotTagNumber.get(i);
		}
		//封装分页
		Page<BigQuiz> p = new Page<>(num, 6);
		p.setList(objects);
		p.setTotalCount(quizNumber);
		//返回数据
		request.setAttribute("page",p);
		request.setAttribute("url",url);
		request.setAttribute("tag",tag);
		request.setAttribute("objects",objects);
		return "community/quiz";
	}

	/**
	 * @author  张正扬
	 * @description 向quiz表插入并取出插入内容
	 * @date  19:58 2018/11/21
	 * @param
	 * @return
	 */

	@RequestMapping(value = "/quiz3",method = RequestMethod.POST)
	public String insertQuiz(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		//int num=Integer.parseInt(request.getParameter("j1"));
		String title=request.getParameter("title");
		System.out.print(title);
		String content= request.getParameter("textarea");
		System.out.print(content);
		this.quizService.saveQuiz(title,content);
		return "/quiz1";
	}
}
