package com.utunan.controller.share;

import com.utunan.pojo.base.share.File;
import com.utunan.pojo.base.user.User;
import com.utunan.pojo.util.Analyzer;
import com.utunan.service.share.ShareIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 孙程程
 * @description: TODO
 * @date 2018/12/15 19:28
 */
@Controller
public class ShareDownloadController {
	@Autowired
	ShareIndexService shareIndexService;

	@RequestMapping("/download")
	public String download(HttpServletRequest request){
		String fileId = request.getParameter("fileId");
		File file=this.shareIndexService.findFileById(Long.parseLong(fileId));
		//以文件标题作为关键字搜索相关文件
		String keyWord=file.getFileTitle();
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
		//相关文件
		List<File> relatedFileList=this.shareIndexService.selectFileByTitle(keyWords);
		//热门文件
		List<File> hotFileList = this.shareIndexService.listHotFile();
		//获取用户信息
		User user = (User)request.getSession().getAttribute("User");
		//下载文件所需积分
		Long fileIntegral = file.getFileCredit();
		//设置操作命令
		String operate = "";
		if(user==null){
			operate="notLogin"; //没有登录
		}else{
			Long userIntegral = user.getUserIntegral();
			if(userIntegral < fileIntegral){
				operate = "lackOfIntegral"; //积分不足
			}else {
				operate = "canDownload"; //可以下载
			}
		}
		//返回数据
		request.setAttribute("operate", operate);
		request.setAttribute("hotFileList", hotFileList);
		request.setAttribute("relatedFileList", relatedFileList);
		request.setAttribute("file", file);
		return "share/download";
	}

	@RequestMapping("downloadfile")
	public String downloadFile(HttpServletRequest request){
		String operate = request.getParameter("operate");

		request.setAttribute("messageValue", operate);
		return "share/downloadresult";
	}
}
