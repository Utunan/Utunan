package com.utunan.controller.community;

import com.github.pagehelper.PageInfo;
import com.utunan.pojo.base.community.Quiz;
import com.utunan.pojo.base.community.QuizGreat;
import com.utunan.pojo.base.community.Tag;
import com.utunan.pojo.base.user.User;
import com.utunan.pojo.inherit.community.BigQuiz;
import com.utunan.service.community.QuizGreatService;
import com.utunan.service.community.QuizService;
import com.utunan.service.community.QuizTagService;
import com.utunan.service.community.TagService;
import com.utunan.util.WordLimitUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpSession;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.sf.json.*;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class QuizController {

	@Autowired
	private QuizService quizService;
	@Autowired
	private TagService tagService;
	@Autowired
    private QuizTagService quizTagService;
	@Autowired
	private QuizGreatService quizGreatService;

	@RequestMapping(value="/quizs/{orderBy}/{pageNum}")
	public String displayQuiz(HttpServletRequest request, @PathVariable String orderBy, @PathVariable String pageNum){
//		String pageNum=request.getParameter("pageNum");
		//判断当前页
		int num=0;
		if(pageNum==null || pageNum.equals("")){
			num=1;
		}else{
			num=Integer.parseInt(pageNum);
		}
		//排序方式
//		String orderBy = request.getParameter("by");
		if (orderBy==null || orderBy.equals("")){
			orderBy="rt";
		}
		String ob = "";
		if (orderBy.equals("pc")){
			ob = "praiseCount";
		}else{
			ob = "releaseTime";
		}
		//提问列表
		List<Quiz> quizList=quizService.listQuiz(ob, num,10);
		//查询前10个评论数量的问题
		List<Quiz> quizListTop10=quizService.quizListTop10();
		//封装BigQuiz
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
			bq.setUser(quizList.get(i).getUser());
			bq.setTagList(quizTagList.get(i));
			bigQuiz.add(bq);
		}
		//热门标签
		Object hotTagList=this.tagService.getTop10Tag();
		//返回排序的选中状态
		if(null!=request.getParameter("stateList")){
			request.setAttribute("stateList",null);
		}
		List<String> stateList=new ArrayList<String>();
		if (orderBy.equals("rt")){
			stateList.add("active");
			stateList.add("option");
		}else{
			stateList.add("option");
			stateList.add("active");
		}

		//返回数据
		request.setAttribute("object",bigQuiz);
		request.setAttribute("url","quizs");
		request.setAttribute("orderBy", orderBy);
		request.setAttribute("tag",hotTagList);
		request.setAttribute("stateList",stateList);
		request.setAttribute("PageInfo",new PageInfo(quizList,5));
		request.setAttribute("quizListTop10",quizListTop10);
		return "community/quiz";
	}

	/**
	 * @author  孙程程
	 * @description 在某标签下分页查询问答列表
	 * @date  15:39 2018/11/26
	 * @param  request
	 * @return  java.lang.String
	 */
	@RequestMapping(value="/quiztag/{tagName}/{orderBy}/{pageNum}")
	public String displayQuizByTag(HttpServletRequest request, @PathVariable String tagName,
                                                               @PathVariable String orderBy,
                                                               @PathVariable String pageNum){
//		String tagName=request.getParameter("tagName");
//		String pageNum=request.getParameter("pageNum");
		//判断当前页
		int num=0;
		if(pageNum==null || pageNum.equals("")){
			num=1;
		}else{
			num=Integer.parseInt(pageNum);
		}
		//排序方式
//		String orderBy = request.getParameter("by");
		if (orderBy==null || orderBy.equals("")){
			orderBy="rt";
		}
		String ob = "";
		if (orderBy.equals("pc")){
			ob = "praiseCount";
		}else{
			ob = "releaseTime";
		}
		//提问列表
		List<Quiz> quizList=this.quizService.listQuizByTag(ob, tagName, num, 10);
		//封装BigQuiz
		//提取quizId列表
		List<Long> quizIdList=new ArrayList<>();
		for(int i=0; i<quizList.size(); i++){
			quizIdList.add(quizList.get(i).getQuizId());
		}
		//获取提问的用户信息
		List<User> userList=new ArrayList<>();
		//获取提问的标签列表
		List<List<Tag>> quizTagList=new ArrayList<>();
		for(int i=0; i<quizList.size(); i++){
			userList.add(quizService.findUserByQuizId(quizIdList.get(i)));
			quizTagList.add(quizService.selectTagByQuizId(quizIdList.get(i)));
		}
		//将提问、评论数量、标签封装
		List<BigQuiz> bigQuiz=new ArrayList<>();
		for (int i=0;i<quizList.size(); i++){
			BigQuiz bq=new BigQuiz();
			bq.setQuiz(quizList.get(i));
			bq.setUser(userList.get(i));
			bq.setTagList(quizTagList.get(i));
			bigQuiz.add(bq);
		}
		//查询前10个评论数量的问题
		List<Quiz> quizListTop10=quizService.quizListTop10();
		//热门标签
		Object hotTagList=this.tagService.getTop10Tag();
		//提问区获取问题数量查询前3个热门标签
		List<Tag> tagList3=this.tagService.getTop3Tag();
		//提问区获取余下标签
		List<Tag> getAllTag=this.tagService.getRemianTags(tagList3);
		//返回排序的选中状态
		if(null!=request.getParameter("stateList")){
			request.setAttribute("stateList",null);
		}
		List<String> stateList=new ArrayList<String>();
		if (orderBy.equals("rt")){
			stateList.add("active");
			stateList.add("option");
		}else{
			stateList.add("option");
			stateList.add("active");
		}
		//返回数据
		request.setAttribute("object",bigQuiz);
		request.setAttribute("url","quiztag");
		request.setAttribute("orderBy", orderBy);
		request.setAttribute("tag",hotTagList);
		request.setAttribute("tags",tagList3);
		request.setAttribute("alltag",getAllTag);
		request.setAttribute("tagName",tagName);
		request.setAttribute("statelist",stateList);
		request.setAttribute("PageInfo",new PageInfo(quizList,5));

		request.setAttribute("quizListTop10",quizListTop10);
		return "community/quiz";
	}

	/**
	 * @author  张正扬
	 * @description 向quiz表插入
	 * @date  19:58 2018/11/21
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/uiz3",method = RequestMethod.POST)
	public String  insertQuiz(HttpServletRequest request , HttpSession session) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		//int num=Integer.parseInt(request.getParameter("j1"));
		String title=request.getParameter("title");
		String t=request.getParameter("tags");
		String content= request.getParameter("textarea");

		User user=(User)session.getAttribute("User");

		Long qid=this.quizService.getMaxQid();
		qid+=1;
		if (t!=null&&!t.equals("")){
            //以中英文逗号、空格（一个或多个）分割字符串
			String regex = ",|，|\\s+";
			String[] tags=t.split(regex);
			//将数组转化为list集合
            List<String> listtag= Arrays.asList(tags);


			//获得用户输入的标签的id
			List<Long> tagss=this.tagService.getTags(listtag);

			this.quizTagService.saveQuizTag(qid,tagss);
		}
		//限定用户登录并且title不为空并且title限定字数为5到20字
		if (user!=null&&WordLimitUtil.isNull(title)&&WordLimitUtil.getLength(title)>=5&&WordLimitUtil.getLength(title)<=20) {
			this.quizService.saveQuiz(qid,user, title, content);
		}
		return "redirect:/quizs/rt";
	}

	/*
	 * @author  张正扬
	 * @description 给问题点赞
	 * @date  21:26 2018/11/27
	 * @param  request
	 * @return  String
	 */
	@ResponseBody
	@RequestMapping(value = "/praise")
	public String praiseQuiz(HttpServletRequest request,HttpSession session){
		String quizId=request.getParameter("quizId");
		User user=(User)session.getAttribute("User");


		//到问题点赞表进行查询是否有记录
		QuizGreat quizGreat=quizGreatService.getQuizGreat(Long.parseLong(quizId),user.getUserId());
		if(quizGreat==null){
			//未进行点赞
            quizGreatService.addQuizGreat(Long.parseLong(quizId),user.getUserId());
            this.quizService.praiseQuiz(Long.parseLong(quizId));
            return "ok";

        }
		else {
			//已点过赞
            quizGreatService.delQuizGreat(Long.parseLong(quizId),user.getUserId());
            this.quizService.delPraiseQuiz(Long.parseLong(quizId));
            return "no";
        }
	}

	/*
	 * @author  王碧云
	 * @description （点击“发表提问”）从问答列表页跳转到提问页
	 * @date  21:54 2018/12/16/016
	 * @param  []
	 * @return  java.lang.String
	 */
	@RequestMapping(value = "/toAddQuestion")
	public String toAddQuestion(){
		return "/community/addQuestion";
	}

}
