package com.dao;

import com.entity.Post;
import com.util.BaseDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * ShowPost
 *
 * @author 孙程程
 * @date 2018/10/31
 */
public class ShowPost {
	public List<Post> showPost(){
		List<Post> listPost = new ArrayList<Post>();
		Connection conn = BaseDao.getConnection();

		try {
			String sql = "select * from post";
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Post p = new Post();
				p.setId(resultSet.getInt(1));
				p.setTitle(resultSet.getString(2));
				p.setText(resultSet.getString(3));
				listPost.add(p);
			}
				return listPost;
		}catch (SQLException e ){
			e.printStackTrace();
			return null;
		}
	}

}
