package com.utunan.controller.share;

import com.utunan.pojo.base.share.File;
import com.utunan.service.share.ShareIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

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
		request.setAttribute("file", file);
		return "share/download";
	}
}
