package com.dao;

import com.entity.Post;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import com.util.BaseDao;

/**
 * InsertPost
 *
 * @author 孙程程
 * @date 2018/10/31
 */
public class InsertPost {
	public Post insertPost(Post post) {
		String title = post.getTitle();
		String text = post.getText();
		try {
			Connection conn = BaseDao.getConnection();
			String sql = "insert into post (title,text) values (?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, text);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}
}
