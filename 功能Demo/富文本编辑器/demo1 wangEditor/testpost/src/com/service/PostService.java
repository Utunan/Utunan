package com.service;

import com.dao.InsertPost;
import com.dao.ShowPost;
import com.entity.Post;

import java.util.List;

/**
 * PostService
 *
 * @author 孙程程
 * @date 2018/10/31
 */
public class PostService {
	public Post insertPost(Post post){
		InsertPost insertPostDao = new InsertPost();
		return insertPostDao.insertPost(post);
	}

	public List<Post> listPost(){
		ShowPost showPost=new ShowPost();
		return showPost.showPost();
	}
}
