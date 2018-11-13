package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * BaseDao
 *
 * @author 孙程程
 * @date 2018/10/31
 */
public class BaseDao {
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnection(){
		String sql="jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8";
		Connection conn;
		try {
			conn = DriverManager.getConnection(sql,"root","");
			return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
}
