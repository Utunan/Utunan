package com.utunan.controller.questionbank;

import com.github.pagehelper.PageInfo;
import com.utunan.pojo.base.questionbank.Question;
import com.utunan.service.questionbank.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author 孙程程
 * @description: TODO
 * @date 2018/12/3 16:19
 */
@Controller
public class QuestionSearchController {
	@Autowired
	private QuestionService questionService;

	/**
	 * @author  孙程程
	 * @description 返回所有题目数量
	 * @date  17:00 2018/12/3
	 * @param  request
	 * @return  java.lang.String
	 */
	@RequestMapping("/searchQuestion")
	public String searchQuestion(HttpServletRequest request){
		Long questionNumber=questionService.countAllQuestion();
		request.setAttribute("totleQuestion","在"+questionNumber+"道题目中搜索");
		return "questionbank/searchQuestion";
	}

	/**
	 * @author  孙程程
	 * @description 题目搜索结果
	 * @date  16:34 2018/12/3
	 * @param  request
	 * @return  java.lang.String
	 */
	@RequestMapping("/searchResult")
	public String searchQuestionResult(HttpServletRequest request){
		String searchValue=request.getParameter("searchValue");
		String pageNum=request.getParameter("pageNum");
		//判断当前页
		int num=0;
		if(pageNum==null || pageNum.equals("")){
			num=1;
		}else{
			num=Integer.parseInt(pageNum);
		}
		//问题列表
		List<Question> questionList=questionService.selectQuestionBySearchValue(searchValue, num,10);
		//返回数据
		request.setAttribute("questionList", questionList);
		request.setAttribute("url","searchResult");
		request.setAttribute("searchValue", searchValue);
		request.setAttribute("PageInfo", new PageInfo(questionList,5));
		return "questionbank/searchQuestion";
	}




}
