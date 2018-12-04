package com.utunan.controller.community;

import com.github.pagehelper.PageInfo;
import com.utunan.pojo.base.community.Answer;
import com.utunan.pojo.base.community.Quiz;
import com.utunan.pojo.base.community.Tag;
import com.utunan.pojo.inherit.community.BigQuiz;
import com.utunan.service.community.AnswerService;
import com.utunan.service.community.PublishQuizService;
import com.utunan.service.community.QuizService;
import com.utunan.service.community.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 孙程程
 * @description: TODO
 * @date 2018/11/26 20:23
 */
@Controller
public class QuizSearchController {
	@Autowired
	private QuizService quizService;
	@Autowired
	private AnswerService answerService;
	@Autowired
	private TagService tagService;

	@Autowired
	private PublishQuizService publishQuizService;

	/**
	 * @author  孙程程
	 * @description 搜索提问
	 * @date  16:58 2018/11/27
	 * @param  request
	 * @return  java.lang.String
	 */
	@RequestMapping(value="/searchQuiz")
	public String searchQuiz(HttpServletRequest request){
		String searchValue=request.getParameter("searchValue");
		String pageNum=request.getParameter("pageNum");
		//判断当前页
		int num=0;
		if(pageNum==null || pageNum.equals("")){
			num=1;
		}else{
			num=Integer.parseInt(pageNum);
		}
		//提问列表
		List<Quiz> quizList=this.quizService.findQuizBySearch(searchValue, num, 6);
		//封装BigQuiz
		//*************以下代码会以同样的姿态在不同地方出现，正在努力封装************
		//提取quizId列表
		List<Long> quizIdList=new ArrayList<>();
		for(int i=0; i<quizList.size(); i++){
			quizIdList.add(quizList.get(i).getQuizId());
		}
		//获取提问的标签列表
		List<List<Tag>> quizTagList=new ArrayList<>();
		for(int i=0; i<quizList.size(); i++){
			quizTagList.add(quizService.selectTagByQuizId(quizIdList.get(i)));
		}
		//将提问、评论数量、标签封装
		List<BigQuiz> bigQuiz=new ArrayList<>();
		for (int i=0;i<quizList.size(); i++){
			BigQuiz bq=new BigQuiz();
			bq.setQuiz(quizList.get(i));
			bq.setTagList(quizTagList.get(i));
			bigQuiz.add(bq);
		}
		//*************以上代码会以同样的姿态在不同地方出现，正在努力封装************
		//返回数据
		request.setAttribute("object",bigQuiz);
		request.setAttribute("url","searchQuiz");
		request.setAttribute("searchValue", searchValue);
		request.setAttribute("PageInfo",new PageInfo(quizList,5));
		return "community/search";
	}

	/**
	 * @author  孙程程
	 * @description 搜索回答
	 * @date  16:59 2018/11/27
	 * @param  request
	 * @return  java.lang.String
	 */
	@RequestMapping("/searchComment")
	public String searchComment(HttpServletRequest request){
		String searchValue=request.getParameter("searchValue");
		String pageNum=request.getParameter("pageNum");
		//判断当前页
		int num=0;
		if(pageNum==null || pageNum.equals("")){
			num=1;
		}else{
			num=Integer.parseInt(pageNum);
		}
		//回答列表
		List<Answer> answerList =this.publishQuizService.findAnswerListBySearch(searchValue, num, 10);

		//返回数据
		request.setAttribute("object", answerList);
		request.setAttribute("url","searchComment");
		request.setAttribute("searchValue", searchValue);
		request.setAttribute("PageInfo",new PageInfo(answerList,5));
		return "community/search";
	}

	/**
	 * @author  孙程程
	 * @description 搜索标签
	 * @date  16:59 2018/11/27
	 * @param  request
	 * @return  java.lang.String
	 */
	@RequestMapping("/searchTag")
	public String searchTag(HttpServletRequest request){
		String searchValue=request.getParameter("searchValue");
		//标签列表
		List<Tag> tagList=this.tagService.findTagListBySearch(searchValue);
		//标签数量
		Long tagNumber=this.tagService.countTagBySearch(searchValue);
		//返回数据
		request.setAttribute("tagList",tagList);
		request.setAttribute("tagNumber",tagNumber);
		request.setAttribute("url","searchTag");
		request.setAttribute("searchValue", searchValue);
		return "community/search";
	}
}
