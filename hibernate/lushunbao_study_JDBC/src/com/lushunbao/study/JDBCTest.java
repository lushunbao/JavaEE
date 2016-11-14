package com.lushunbao.study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTest {
	public static void main(String[] args) throws Exception {
		Connection conn;
		String url = "jdbc:mysql://localhost:3306/jdbc?"
                + "user=root&password=123654&useUnicode=true&characterEncoding=UTF8";
		
		//加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("加载驱动完成");
		
		conn = DriverManager.getConnection(url);
		Statement stat = conn.createStatement();
		
		String sql = "select * from student";
		ResultSet res = stat.executeQuery(sql);
		while(res.next()){
			System.out.println("id=" + res.getInt(1) + "\t" + "name=" + res.getString(2) + "\t" + "age=" + res.getInt(3));
		}
	}
}
