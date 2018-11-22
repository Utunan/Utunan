package com.utunan.controller.community;

import com.utunan.pojo.community.Quiz;
import com.utunan.pojo.community.Tag;
import com.utunan.pojo.user.User;
import com.utunan.pojo.util.Page;
import com.utunan.service.community.QuizService;
import com.utunan.service.community.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

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
		//提问列表
		List<Quiz> list=this.quizService.getQuizByTime(num,6);
		//提问数量
		Long count = this.quizService.countAllQuiz();
		//热门标签
		List<Tag> name=this.tagService.getTop10Tag();
		//热门标签的回答数量
		List<Long> number=this.tagService.getTop10TagNumber();
		//评论数量
		List<Long> commentNumber=this.quizService.countCommentByTime(num,6);
		//封装提问列表与评论数量
		List<HashMap<Quiz,Long>> list1=new ArrayList<>();
		for (int j=0;j<list.size(); j++){
			HashMap<Quiz,Long> hm=new HashMap<>();
			hm.put(list.get(j),commentNumber.get(j));
			list1.add(hm);
		}
		//封装热门标签和标签数量
		Object[][] tag=new Object[10][2];
		for(int i=0; i<name.size(); i++){
			tag[i][0]=name.get(i);
			tag[i][1]=number.get(i);
		}
		//封装分页
		Page<HashMap<Quiz,Long>> p = new Page<HashMap<Quiz,Long>>(num, 6);
		p.setList(list1);
		p.setTotalCount(count);


		//****************************************************************
//		List<Long> quizId=new ArrayList<>();
//		for (int j=0;j<list.size(); j++){
//			quizId.add(list.get(j).getQuizId());
//		}
//		List<User> userList=new ArrayList<>();
//		for (int j=0;j<quizId.size(); j++){
//			userList.add(this.quizService.findUserByQuizId(quizId.get(j)));
//		}
//		List<HashMap<Quiz,User>> list9=new ArrayList<>();
//		for (int j=0;j<list.size(); j++){
//			HashMap<Quiz,User> hm=new HashMap<>();
//			hm.put(list.get(j),userList.get(j));
//			list9.add(hm);
//		}
//		List<HashMap<Tag,Long>> list8=new ArrayList<>();
//		for (int j=0;j<list.size(); j++){
//			HashMap<Tag,Long> hm=new HashMap<>();
//			hm.put(name.get(j),commentNumber.get(j));
//			list8.add(hm);
//		}
//		List<HashMap<HashMap<Quiz,User>,HashMap<Tag,Long>>> list7=new ArrayList<>();
//		for (int j=0;j<list.size(); j++){
//			HashMap<HashMap<Quiz,User>,HashMap<Tag,Long>> hm=new HashMap<>();
//			hm.put(list9.get(j),list8.get(j));
//			list7.add(hm);
//		}


//		List<Object> objects=new ArrayList<>();
//		for (int j=0;j<quizId.size(); j++){
//			List<Object> obj=new ArrayList<>();
//			obj.add(list.get(j));
//			obj.add(userList.get(j));
//			objects.add(obj);
//		}
//		for (int j=0;j<quizId.size(); j++){
//			System.out.println(objects.get(j));
//		}
		//****************************************************************

		request.setAttribute("page",p);
		request.setAttribute("url",url);
		request.setAttribute("tag",tag);
//		request.setAttribute("objects",list7);
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
		//评论数量
		List<Long> commentNumber=this.quizService.countCommentByPraise(num,6);
		//封装提问列表与评论数量
		List<HashMap<Quiz,Long>> list1=new ArrayList<>();
		for (int j=0;j<list.size(); j++){
			HashMap<Quiz,Long> hm=new HashMap<>();
			hm.put(list.get(j),commentNumber.get(j));
			list1.add(hm);
		}
		//封装热门标签的提问数量
		Object[][] tag=new Object[10][2];
		for(int i=0; i<name.size(); i++){
			tag[i][0]=name.get(i);
			tag[i][1]=number.get(i);
		}
		//封装分页
		Page<HashMap<Quiz,Long>> p = new Page<HashMap<Quiz,Long>>(num, 6);
		p.setList(list1);
		p.setTotalCount(count);

		request.setAttribute("page",p);
		request.setAttribute("url",url);
		request.setAttribute("tag",tag);
		return "community/quiz";
	}

}
