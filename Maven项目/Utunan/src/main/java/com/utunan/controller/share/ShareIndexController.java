package com.utunan.controller.share;

import com.github.pagehelper.PageInfo;
import com.utunan.pojo.base.school.School;
import com.utunan.pojo.base.share.File;
import com.utunan.pojo.util.Analyzer;
import com.utunan.service.share.ShareIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
	public String shareIndex(HttpServletRequest request){
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
		return "share/share";
	}

	@RequestMapping("searchfile")
	public String searchFile(HttpServletRequest request){
		//文件类型
		String[] fileType = request.getParameterValues("fileType");
		List<String> fileTypes=new ArrayList<>(fileType.length);
		Collections.addAll(fileTypes,fileType);
		//文件所属学校
		String fileSchool = request.getParameter("school");
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
		List<String> keyWords= new ArrayList<>();
		if(keyWord.equals("") || keyWord==null){
			keyWords.add(".");
		}else{
			//对搜索条件进行分词
			keyWord.replaceAll("<","");
			keyWord.replaceAll(">","");
			Analyzer analyzer=new Analyzer();
			try {
				keyWords = analyzer.Analyzer(keyWord);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//文件列表
		List<File> fileList = this.shareIndexService.selectFile(fileTypes, fileSchool, keyWords, num, 10);
		request.setAttribute("fileList", fileList);
		request.setAttribute("url", "searchfile");
		request.setAttribute("PageInfo",new PageInfo(fileList,5));
		return "share/share";
	}

	@RequestMapping("/share1")
	public String shareIndex(){
		return "share/upload";
	}
}
