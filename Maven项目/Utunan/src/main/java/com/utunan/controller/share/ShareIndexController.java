package com.utunan.controller.share;

import com.github.pagehelper.PageInfo;
import com.utunan.pojo.base.school.School;
import com.utunan.pojo.base.share.File;
import com.utunan.pojo.base.user.User;
import com.utunan.pojo.util.Analyzer;
import com.utunan.service.share.ShareIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;

/**
 * @author 孙程程
 * @description: TODO
 * @date 2018/12/10 16:59
 */
@Controller
public class ShareIndexController {
	@Autowired
	private ShareIndexService shareIndexService;

	@RequestMapping("/share")
	public String shareIndex(HttpServletRequest request,HttpSession session){
	    User user = (User) session.getAttribute("User");
		String pageNum=request.getParameter("pageNum");
		//判断当前页
		int num=0;
		if(pageNum==null || pageNum.equals("")){
			num=1;
		}else{
			num=Integer.parseInt(pageNum);
		}
		//学校地区
		List<String> provinceList = this.shareIndexService.listSchoolProvince();
		//学校
		List<School> schoolList = this.shareIndexService.listSchool();
		//最新文件
		List<File> fileList = this.shareIndexService.listFileByTime(num,10);
		//热门文件
		List<File> hotFileList = this.shareIndexService.listHotFile();
		request.setAttribute("url","share");
		request.setAttribute("provinceList", provinceList);
		request.setAttribute("schoolList", schoolList);
		request.setAttribute("fileList", fileList);
		request.setAttribute("hotFileList", hotFileList);
		request.setAttribute("PageInfo",new PageInfo(fileList,5));
		request.setAttribute("user", user);
		return "share/index";
	}

	@RequestMapping("searchfile")
	public String searchFile(HttpServletRequest request, @RequestParam(value = "fileType",required = false) String[] fileType){
		//文件所属学校
		String fileSchool = request.getParameter("school");
		String fs = "";
		if(fileSchool==null || fileSchool.equals("")){
			fs = "%%";
		}else {
			fs = fileSchool;
		}
		//当前页码
		String pageNum=request.getParameter("pageNum");
		//判断当前页
		int num=0;
		if(pageNum==null || pageNum.equals("")){
			num=1;
		}else{
			num=Integer.parseInt(pageNum);
		}
		//搜索的关键字
		String keyWord=request.getParameter("keyWord");
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
		List<File> fileList = this.shareIndexService.selectFile(fileType, fs, keyWords, num, 10);
		//热门文件
		List<File> hotFileList = this.shareIndexService.listHotFile();
		//学校地区
		List<String> provinceList = this.shareIndexService.listSchoolProvince();
		//学校
		List<School> schoolList = this.shareIndexService.listSchool();
		request.setAttribute("provinceList", provinceList);
		request.setAttribute("schoolList", schoolList);
		request.setAttribute("fileList", fileList);
		request.setAttribute("hotFileList", hotFileList);
		request.setAttribute("url", "searchfile");
		request.setAttribute("fileType", String.join(",", fileType));
		request.setAttribute("school", fileSchool);
		request.setAttribute("keyWord", keyWord);
		request.setAttribute("PageInfo",new PageInfo(fileList,5));
		return "share/index";
	}

	@RequestMapping("/share1")
	public String shareInex(HttpServletRequest request, HttpSession session){
		//学校地区
		List<String> provinceList = this.shareIndexService.listSchoolProvince();
		//学校
		List<School> schoolList = this.shareIndexService.listSchool();

		request.setAttribute("provinceList", provinceList);
		request.setAttribute("schoolList", schoolList);
		return "share/upload";
	}


}
