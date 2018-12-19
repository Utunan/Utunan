package com.utunan.controller.share;

import com.utunan.pojo.base.share.File;
import com.utunan.pojo.base.share.FileGreat;
import com.utunan.pojo.base.share.UserDownload;
import com.utunan.pojo.base.user.User;
import com.utunan.pojo.util.Analyzer;
import com.utunan.service.share.ShareIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
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

	/**
	 * @author  孙程程
	 * @description 下载界面
	 * @date  10:32 2018/12/19
	 * @param  request
	 * @return  java.lang.String
	 */
	@RequestMapping("/file/{fileId}")
	public String download(HttpServletRequest request, @PathVariable String fileId){
//		String fileId = request.getParameter("fileId");
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
			User user1 = this.shareIndexService.findUserById(user.getUserId());
			UserDownload userDownload=this.shareIndexService.findUserDownload(user1.getUserId(), file.getFileId());
			if(userDownload==null){
				//用户现有积分
				Long userIntegral = user1.getUserIntegral();
				if(userIntegral < fileIntegral || userIntegral < 0){
					operate = "lackOfIntegral"; //积分不足
				}else {
					operate = "canDownload"; //可以下载
				}
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

	/**
	 * @author  孙程程
	 * @description 下载功能
	 * @date  10:32 2018/12/19
	 * @param  request, response
	 * @return  void
	 */
	@RequestMapping("downloadfile")
	public void downloadFile(HttpServletRequest request, HttpServletResponse response) {
		//获取文件信息
		String fileId = request.getParameter("fileId");
		File file=this.shareIndexService.findFileById(Long.parseLong(fileId));
		//获取用户信息
		User user = (User)request.getSession().getAttribute("User");
		User user1 = this.shareIndexService.findUserById(user.getUserId());
		//获得请求文件名
		String name = file.getFileTitle();
		String path = file.getFileUrl();
		//文件后缀
		String suffix = "."+path.substring(path.lastIndexOf(".")+1);
		String fileName = null;
		try {
			fileName = new String(name.getBytes("GBK"), "ISO-8859-1")+suffix;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		java.io.File file1 = new java.io.File(path);
		response.reset();
		response.setContentType("application/octet-stream");
		response.setCharacterEncoding("utf-8");
		response.setContentLength((int) file1.length());
		response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
		byte[] buff = new byte[1024];
		BufferedInputStream bis = null;
		OutputStream os = null;
		try {
			os = response.getOutputStream();
			bis = new BufferedInputStream(new FileInputStream(file1));
			int i = 0;
			while ((i = bis.read(buff)) != -1) {
				os.write(buff, 0, i);
				os.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//更新文件的下载次数
		this.shareIndexService.updateFileDownloadNumber(file.getFileId(), file.getDownloadNumber()+1);
		//判断用户是否下载过该文件
		UserDownload userDownload=this.shareIndexService.findUserDownload(user.getUserId(), file.getFileId());
		if(userDownload==null){
			//向用户下载表插入数据
			this.shareIndexService.insertUserDownload(user.getUserId(), file.getFileId());
			//更新用户积分
			this.shareIndexService.updateUserIntegral(user.getUserId(),user1.getUserIntegral()-file.getFileCredit());
		}
	}

	/**
	 * @author  孙程程
	 * @description 赞
	 * @date  10:32 2018/12/19
	 * @param  request
	 * @return  java.lang.String
	 */
	@RequestMapping(value = "/fileUp", method = RequestMethod.GET)
	public String fileUp(HttpServletRequest request){
		String fileId = request.getParameter("fileId");
		File file = this.shareIndexService.findFileById(Long.parseLong(fileId));
		//获取用户信息
		User user = (User)request.getSession().getAttribute("User");
		if (user != null){
			//查询用户是否赞过
			FileGreat fileGreat1 = this.shareIndexService.findFileGreat(user.getUserId(),file.getFileId(),Long.parseLong("1"));
			//查询用户是否踩过
			FileGreat fileGreat2 = this.shareIndexService.findFileGreat(user.getUserId(),file.getFileId(),Long.parseLong("2"));
			if (fileGreat2 == null){
				//用户没有踩过，可以进行相关操作
				if (fileGreat1 == null){
					//用户没有赞过
					//插入点赞信息
					this.shareIndexService.insertFileGreat(user.getUserId(), file.getFileId(), Long.parseLong("1"));
					//更新点赞数量
					this.shareIndexService.updateFileUpNumber(file.getFileId(), file.getUpNumber()+1);
				}else {
					//用户已经赞过，取消赞
					//删除点赞信息
					this.shareIndexService.deleteFileGreat(user.getUserId(), file.getFileId(), Long.parseLong("1"));
					//更新点赞数量
					this.shareIndexService.updateFileUpNumber(file.getFileId(), file.getUpNumber()-1);
				}
			}
		}
		return "redirect:/download?fileId="+fileId;
	}

	/**
	 * @author  孙程程
	 * @description 踩
	 * @date  10:32 2018/12/19
	 * @param  request
	 * @return  java.lang.String
	 */
	@RequestMapping(value = "/fileDown", method = RequestMethod.GET)
	public String fileDown(HttpServletRequest request){
		String fileId = request.getParameter("fileId");
		File file = this.shareIndexService.findFileById(Long.parseLong(fileId));
		//获取用户信息
		User user = (User)request.getSession().getAttribute("User");
		if (user != null){
			//查询用户是否赞过
			FileGreat fileGreat1 = this.shareIndexService.findFileGreat(user.getUserId(),file.getFileId(),Long.parseLong("1"));
			//查询用户是否踩过
			FileGreat fileGreat2 = this.shareIndexService.findFileGreat(user.getUserId(),file.getFileId(),Long.parseLong("2"));
			if (fileGreat1 == null){
				//用户没有赞过，可以进行相关操作
				if (fileGreat2 == null){
					//用户没有踩过
					//插入踩的信息
					this.shareIndexService.insertFileGreat(user.getUserId(), file.getFileId(), Long.parseLong("2"));
					//更新踩的数量
					this.shareIndexService.updateFileDownNumber(file.getFileId(), file.getDownNumber()+1);
				}else {
					//用户已经踩过，取消踩
					//删除踩的信息
					this.shareIndexService.deleteFileGreat(user.getUserId(), file.getFileId(), Long.parseLong("2"));
					//更新踩的数量
					this.shareIndexService.updateFileDownNumber(file.getFileId(), file.getDownNumber()-1);
				}
			}
		}
		return "redirect:/download?fileId="+fileId;
	}

}
