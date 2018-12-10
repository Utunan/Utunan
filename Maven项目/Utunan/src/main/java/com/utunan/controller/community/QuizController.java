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
import org.apache.commons.lang.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpSession;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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


	
	/**
	 * @author  孙程程
	 * @description 根据发表时间展示问答列表
	 * @date  17:52 2018/11/20
	 * @param  request
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
		//提问列表
		List<Quiz> quizList=quizService.quizListByTime(num,6);

		//查询前10个评论数量的问题
		List<Quiz> quizListTop10=quizService.quizListTop10();
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
			bq.setUser(quizList.get(i).getUser());
			bq.setTagList(quizTagList.get(i));
			bigQuiz.add(bq);
		}
		//*************以上代码会以同样的姿态在不同地方出现，正在努力封装************
		//热门标签
		Object hotTagList=this.tagService.getTop10Tag();
		//提问区获取问题数量查询前3个热门标签
		List<Tag> tagList3=this.tagService.getTop3Tag();
		//提问区获取余下标签
		List<Tag> getAllTag=this.tagService.getRemianTags(tagList3);
		//返回排序的选中状态
		List<String> stateList=new ArrayList<String>();
		stateList.add("active");
		stateList.add("option");
		//返回数据
		request.setAttribute("object",bigQuiz);
		request.setAttribute("url","quiz1");
		request.setAttribute("tag",hotTagList);
		request.setAttribute("tags",tagList3);
		request.setAttribute("alltag",getAllTag);
		request.setAttribute("statelist",stateList);
		request.setAttribute("PageInfo",new PageInfo(quizList,5));
		request.setAttribute("quizListTop10",quizListTop10);
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
		String pageNum=request.getParameter("pageNum");
		//判断当前页
		int num=0;
		if(pageNum==null || pageNum.equals("")){
			num=1;
		}else{
			num=Integer.parseInt(pageNum);
		}
		//提问列表
		List<Quiz> quizList=quizService.quizListByPraise(num,6);


        //查询前10个评论数量的问题
        List<Quiz> quizListTop10=quizService.quizListTop10();
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
			bq.setUser(quizList.get(i).getUser());
			bq.setTagList(quizTagList.get(i));
			bigQuiz.add(bq);
		}
		//*************以上代码会以同样的姿态在不同地方出现，正在努力封装************
		//热门标签
		Object hotTagList=this.tagService.getTop10Tag();
		//提问区获取问题数量查询前3个热门标签
		List<Tag> tagList3=this.tagService.getTop3Tag();
		//提问区获取余下标签
		List<Tag> getAllTag=this.tagService.getRemianTags(tagList3);
		//返回排序的选中状态
		List<String> stateList=new ArrayList<String>();
		stateList.add("option");
		stateList.add("active");
	
		//返回数据
		request.setAttribute("object",bigQuiz);
		request.setAttribute("url","quiz2");
		request.setAttribute("tag",hotTagList);
		request.setAttribute("tags",tagList3);
		request.setAttribute("alltag",getAllTag);
		request.setAttribute("statelist",stateList);
		request.setAttribute("PageInfo",new PageInfo(quizList,5));
        request.setAttribute("quizListTop10",quizListTop10);
		return "community/quiz";
	}
	
	/**
	 * @author  张正扬
	 * @description 向quiz表插入并取出插入内容
	 * @date  19:58 2018/11/21
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/uiz3",method = RequestMethod.POST)
	public String insertQuiz(HttpServletRequest request , HttpSession session) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		//int num=Integer.parseInt(request.getParameter("j1"));
		String title=request.getParameter("title");
		String t=request.getParameter("tags");
		String content= request.getParameter("textarea");

		User user=(User)session.getAttribute("User");

		Long qid=this.quizService.getMaxQid();
		qid+=1;
		if (t!=null&&!t.equals("")){
			String regex = ",|，|\\s+";    //以中英文逗号、空格（一个或多个）分割字符串
			String[] tags=t.split(regex);
			//将数组转化为list集合
			List<String> listtag= Arrays.asList(tags);

			//获得用户输入的标签的id
			List<Long> tagss=this.tagService.getTags(listtag);

			this.quizTagService.saveQuizTag(qid,tagss);
		}
		//限定用户登录并且title不为空并且title限定字数为7到50字
		if (user!=null&&WordLimitUtil.isNull(title)&&WordLimitUtil.getLength(title)>=7&&WordLimitUtil.getLength(title)<=50) {
			this.quizService.saveQuiz(qid,user, title, content);
		}
		return "redirect:/quiz1 ";
	}

	/**
	 * @author  孙程程
	 * @description 在某标签下根据发表时间分页查询问答列表
	 * @date  15:39 2018/11/26
	 * @param  request
	 * @return  java.lang.String
	 */
	@RequestMapping(value="/quiz3")
	public String displayQuizByTimeWithTagName(HttpServletRequest request){
		String tagName=request.getParameter("tagName");
		String pageNum=request.getParameter("pageNum");
		//判断当前页
		int num=0;
		if(pageNum==null || pageNum.equals("")){
			num=1;
		}else{
			num=Integer.parseInt(pageNum);
		}
		//提问列表
		List<Quiz> quizList=this.quizService.quizListByTimeWithTagName(tagName, num,6);
		//封装BigQuiz
		//*************以下代码会以同样的姿态在不同地方出现，正在努力封装************
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
		//*************以上代码会以同样的姿态在不同地方出现，正在努力封装************
		//热门标签
		Object hotTagList=this.tagService.getTop10Tag();
		//返回排序的选中状态
		List<String> stateList=new ArrayList<String>();
		stateList.add("active");
		stateList.add("option");
		//返回数据
		request.setAttribute("object",bigQuiz);
		request.setAttribute("url","quiz3");
		request.setAttribute("tag",hotTagList);
		request.setAttribute("tagName",tagName);
		request.setAttribute("statelist",stateList);
		request.setAttribute("PageInfo",new PageInfo(quizList,5));
		return "community/quiz";
	}
	
	/**
	 * @author  孙程程
	 * @description 在某标签下根据点赞数量分页查询问答列表
	 * @date  15:39 2018/11/26
	 * @param  request
	 * @return  java.lang.String
	 */
	@RequestMapping(value="/quiz4")
	public String displayQuizByPraiseWithTagName(HttpServletRequest request){
		String tagName=request.getParameter("tagName");
		String pageNum=request.getParameter("pageNum");
		//判断当前页
		int num=0;
		if(pageNum==null || pageNum.equals("")){
			num=1;
		}else{
			num=Integer.parseInt(pageNum);
		}
		//提问列表
		List<Quiz> quizList=this.quizService.quizListByPraiseWithTagName(tagName, num,6);
		//封装BigQuiz
		//*************以下代码会以同样的姿态在不同地方出现，正在努力封装************
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
		//*************以上代码会以同样的姿态在不同地方出现，正在努力封装************
		//热门标签
		Object hotTagList=this.tagService.getTop10Tag();
		//返回排序的选中状态
		List<String> stateList=new ArrayList<String>();
		stateList.add("option");
		stateList.add("active");
		//返回数据
		request.setAttribute("object",bigQuiz);
		request.setAttribute("url","quiz4");
		request.setAttribute("tag",hotTagList);
		request.setAttribute("tagName",tagName);
		request.setAttribute("statelist",stateList);
		request.setAttribute("PageInfo",new PageInfo(quizList,5));
		return "community/quiz";
	}
	
	/*
	 * @author  张正扬
	 * @description 给问题点赞
	 * @date  21:26 2018/11/27
	 * @param  request
	 * @return  String
	 */
	@RequestMapping(value = "/praise")
	public String praiseQuiz(HttpServletRequest request,HttpSession session){
		String quizId=request.getParameter("quizId");
		User user=(User)session.getAttribute("User");
		//到问题点赞表进行查询是否有记录
		QuizGreat quizGreat=quizGreatService.getQuizGreat(Long.parseLong(quizId),user.getUserId());
		if(quizGreat==null){
            quizGreatService.addQuizGreat(Long.parseLong(quizId),user.getUserId());
            this.quizService.praiseQuiz(Long.parseLong(quizId));
        }
		else {
            quizGreatService.delQuizGreat(Long.parseLong(quizId),user.getUserId());
            this.quizService.delPraiseQuiz(Long.parseLong(quizId));
        }



		return "redirect:/quiz1";
	}
}
