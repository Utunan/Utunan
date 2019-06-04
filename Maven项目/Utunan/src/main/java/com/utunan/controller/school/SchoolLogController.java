package com.utunan.controller.school;

import com.utunan.pojo.base.school.DirectionComment;
import com.utunan.pojo.base.user.DirectionCollector;
import com.utunan.pojo.base.user.User;
import com.utunan.service.school.SchoolLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author 孙程程
 * @description: TODO
 * @date 2019/6/4 11:31
 */
@Controller
public class SchoolLogController {

	@Autowired
	private SchoolLogService schoolLogService;

	@RequestMapping(value = "/schoolLog")
	public void fileUp(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//获取用户信息
		User user = (User) request.getSession().getAttribute("User");
		String userId;
		if (user == null || user.equals("")){
			userId = "0";
		}else {
			userId = user.getUserId().toString();
		}

		String time = request.getParameter("time");
		String pathname = request.getParameter("pathname");

		String u = new StringBuffer(pathname).reverse().toString();
		String directionId = u.substring(0, u.indexOf("/"));

		DirectionCollector directionCollector = schoolLogService.findGreatByUserAndDirection(Long.parseLong(userId), Long.parseLong(directionId));
		String isGreat;
		if (directionCollector == null){
			isGreat = "0";
		}else {
			isGreat = "1";
		}

		DirectionComment directionComment = schoolLogService.findCommentByUserAndDirection(Long.parseLong(userId), Long.parseLong(directionId));
		String isComment;
		if (directionComment == null){
			isComment = "0";
		}else {
			isComment = "1";
		}

		System.out.println("userId:"+ userId + ' ' + "directionId:"+ directionId + ' '+ "time:" + time + ' ' + "isGreat:" + isGreat + ' ' + "isComment:" + isComment);

		FileWriter fw = null;
		try {
			//如果文件存在，则追加内容；如果文件不存在，则创建文件
			File f=new File("d:/output.txt");
			fw = new FileWriter(f, true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		PrintWriter pw = new PrintWriter(fw);
		pw.println(userId + ' ' + directionId + ' '+ time + ' ' + isGreat + ' ' + isComment);
		pw.flush();
		try {
			fw.flush();
			pw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
