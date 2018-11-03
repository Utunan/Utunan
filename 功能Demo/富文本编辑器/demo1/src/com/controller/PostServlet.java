package com.controller;

import com.entity.Post;
import com.service.PostService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * com.controller.PostServlet
 *
 * @author 孙程程
 * @date 2018/10/28
 */

public class PostServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		//获取标题
		String title=request.getParameter("hidden1");
		//获取帖子内容（html格式）
		String text=request.getParameter("hidden2");
		//封装Post
		Post post=new Post();
		post.setTitle(title);
		post.setText(text);
		//调用PostService
		PostService postService=new PostService();
		postService.insertPost(post);

		List<Post> listPost = postService.listPost();

		HttpSession session = request.getSession();
		session.setAttribute("listPost",listPost);

		request.getRequestDispatcher("index.jsp").forward(request,response);

	}
}
