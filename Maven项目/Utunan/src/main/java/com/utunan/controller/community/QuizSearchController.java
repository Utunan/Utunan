package com.utunan.controller.community;

import com.utunan.pojo.community.Comment;
import com.utunan.pojo.community.Quiz;
import com.utunan.pojo.community.Tag;
import com.utunan.pojo.util.BigQuiz;
import com.utunan.pojo.util.Page;
import com.utunan.service.community.CommentService;
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
	private CommentService commentService;
	@Autowired
	private TagService tagService;

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
		List<BigQuiz> objects=this.quizService.findQuizBySearch(searchValue, num, 6);
		//提问数量
		Long quizNumber = this.quizService.countQuizBySearch(searchValue);
		//封装分页
		Page<BigQuiz> p = new Page<>(num, 6);
		p.setList(objects);
		p.setTotalCount(quizNumber);
		//返回数据
		request.setAttribute("page",p);
		request.setAttribute("url","searchQuiz");
		request.setAttribute("searchValue", searchValue);
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
		List<Comment> commentList=this.commentService.findCommentListBySearch(searchValue, num, 10);
		//回答数量
		Long commentNumber=this.commentService.countCommentBySearch(searchValue);
		//封装分页
		Page<Comment> p = new Page<>(num, 6);
		p.setList(commentList);
		p.setTotalCount(commentNumber);
		//返回排序的选中状态
		List<String> stateList=new ArrayList<String>();
		stateList.add("option");
		stateList.add("active");
		//返回数据
		request.setAttribute("page",p);
		request.setAttribute("url","searchComment");
		request.setAttribute("searchValue", searchValue);
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

		//返回排序的选中状态
		List<String> stateList=new ArrayList<String>();
		stateList.add("option");
		stateList.add("active");
		//返回数据
		request.setAttribute("tagList",tagList);
		request.setAttribute("tagNumber",tagNumber);
		request.setAttribute("url","searchTag");
		request.setAttribute("searchValue", searchValue);
		return "community/search";
	}
}
