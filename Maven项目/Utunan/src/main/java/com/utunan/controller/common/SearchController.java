package com.utunan.controller.common;

import com.github.pagehelper.PageInfo;
import com.utunan.pojo.base.community.Answer;
import com.utunan.pojo.base.community.Quiz;
import com.utunan.pojo.base.community.Tag;
import com.utunan.pojo.base.share.File;
import com.utunan.pojo.base.user.User;
import com.utunan.pojo.inherit.community.BigQuiz;
import com.utunan.pojo.util.Analyzer;
import com.utunan.service.common.SearchService;
import com.utunan.service.community.QuizService;
import com.utunan.service.community.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 孙程程
 * @description: TODO
 * @date 2018/12/8 14:06
 */
@Controller
public class SearchController {
	@Autowired
	private SearchService searchService;
	@Autowired
	private QuizService quizService;
	@Autowired
	private TagService tagService;


	/**
	 * @author  孙程程
	 * @description 搜索用户
	 * @date  17:14 2018/12/9
	 * @param  request
	 * @return  java.lang.String
	 */
	@RequestMapping("/search/user")
	public String searchUser(HttpServletRequest request){
		String keyWord=request.getParameter("wd");
		Analyzer analyzer=new Analyzer();
		//过滤关键词
		keyWord=analyzer.filter(keyWord);
		List<String> keyWords= new ArrayList<>();
		if(keyWord.equals("") || keyWord==null){
			keyWords.add(".");
		}else{
			//对搜索条件进行分词
			try {
				keyWords = analyzer.Analyzer(keyWord);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//返回用户列表
		List<User> userList=this.searchService.findUser(keyWords);
		//返回数据
		request.setAttribute("object", userList);
		request.setAttribute("url","/search/user");
		request.setAttribute("keyWord", keyWord);
		request.setAttribute("PageInfo",new PageInfo(userList,5));
		return "common/searchresult";
	}

	/**
	 * @author  孙程程
	 * @description 搜索提问
	 * @date  17:14 2018/12/9
	 * @param  request
	 * @return  java.lang.String
	 */
	@RequestMapping("/search/quiz/{pageNum}")
	public String searchQuiz(HttpServletRequest request, @PathVariable String pageNum) {
//		String pageNum=request.getParameter("p");
		//判断当前页
		int num=0;
		if(pageNum==null || pageNum.equals("")){
			num=1;
		}else{
			num=Integer.parseInt(pageNum);
		}
		String keyWord=request.getParameter("wd");
		Analyzer analyzer=new Analyzer();
		//过滤关键词
		keyWord=analyzer.filter(keyWord);
		List<String> keyWords= new ArrayList<>();
		if(keyWord.equals("") || keyWord==null){
			keyWords.add(".");
		}else{
			//对搜索条件进行分词
			try {
				keyWords = analyzer.Analyzer(keyWord);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//返回提问列表
		List<Quiz> quizList = this.searchService.findQuiz(keyWords, num, 10);
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
		//将提问、标签封装
		List<BigQuiz> bigQuiz=new ArrayList<>();
		for (int i=0;i<quizList.size(); i++){
			BigQuiz bq=new BigQuiz();
			bq.setQuiz(quizList.get(i));
			bq.setTagList(quizTagList.get(i));
			bigQuiz.add(bq);
		}
		//热门标签
		Object hotTagList=this.tagService.getTop10Tag();
		//查询前10个评论数量的问题
		List<Quiz> quizListTop10=quizService.quizListTop10();
		//返回数据
		request.setAttribute("quizListTop10",quizListTop10);
		request.setAttribute("tag",hotTagList);
		request.setAttribute("object",bigQuiz);
		request.setAttribute("url","/search/quiz");
		request.setAttribute("keyWord", keyWord);
		request.setAttribute("PageInfo",new PageInfo(quizList,5));
		return "common/searchresult";
	}

	/**
	 * @author  孙程程
	 * @description 搜索回答
	 * @date  17:14 2018/12/9
	 * @param  request
	 * @return  java.lang.String
	 */
	@RequestMapping("/search/answer/{pageNum}")
	public String searchAnswer(HttpServletRequest request, @PathVariable String pageNum){
		//判断当前页
		int num=0;
		if(pageNum==null || pageNum.equals("")){
			num=1;
		}else{
			num=Integer.parseInt(pageNum);
		}
		String keyWord=request.getParameter("wd");
		Analyzer analyzer=new Analyzer();
		//过滤关键词
		keyWord=analyzer.filter(keyWord);
		List<String> keyWords= new ArrayList<>();
		if(keyWord.equals("") || keyWord==null){
			keyWords.add(".");
		}else{
			//对搜索条件进行分词
			try {
				keyWords = analyzer.Analyzer(keyWord);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//回答列表
		List<Answer> answerList =this.searchService.findAnswer(keyWords, num, 10);
		//热门标签
		Object hotTagList=this.tagService.getTop10Tag();
		//查询前10个评论数量的问题
		List<Quiz> quizListTop10=quizService.quizListTop10();
		//返回数据
		request.setAttribute("quizListTop10",quizListTop10);
		request.setAttribute("tag",hotTagList);
		request.setAttribute("object", answerList);
		request.setAttribute("url","/search/answer");
		request.setAttribute("keyWord", keyWord);
		request.setAttribute("PageInfo",new PageInfo(answerList,5));
		return "common/searchresult";
	}

	@RequestMapping("/search/file/{pageNum}")
	public String searchFile(HttpServletRequest request, @PathVariable String pageNum){
		//判断当前页
		int num=0;
		if(pageNum==null || pageNum.equals("")){
			num=1;
		}else{
			num=Integer.parseInt(pageNum);
		}
		String keyWord=request.getParameter("wd");
		Analyzer analyzer=new Analyzer();
		//过滤关键词
		keyWord=analyzer.filter(keyWord);
		List<String> keyWords= new ArrayList<>();
		if(keyWord.equals("") || keyWord==null){
			keyWords.add(".");
		}else{
			//对搜索条件进行分词
			try {
				keyWords = analyzer.Analyzer(keyWord);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//文件列表
		List<File> fileList = this.searchService.findFile(keyWords,num,10);
		//热门标签
		Object hotTagList=this.tagService.getTop10Tag();
		//查询前10个评论数量的问题
		List<Quiz> quizListTop10=quizService.quizListTop10();
		//返回数据
		request.setAttribute("quizListTop10",quizListTop10);
		request.setAttribute("tag",hotTagList);
		request.setAttribute("object", fileList);
		request.setAttribute("url","/search/file");
		request.setAttribute("keyWord", keyWord);
		request.setAttribute("PageInfo",new PageInfo(fileList,5));
		return "common/searchresult";
	}
}
