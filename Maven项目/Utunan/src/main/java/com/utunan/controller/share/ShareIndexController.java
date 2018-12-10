package com.utunan.controller.share;

import com.utunan.pojo.base.share.File;
import com.utunan.service.share.ShareIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
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
		List<File> fileList = this.shareIndexService.listFileByTime();
		request.setAttribute("fileList", fileList);
		return "share/share";
	}
}
