package com.pro.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbHelper {
	public static Connection getConn() throws Exception {
		Connection conn = null;
		Class.forName("oracle.jdbc.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.3.8:1521/orcl", "lijian", "lijian");
		return conn;
	}
	
	public static void closeAll(Connection conn) throws Exception {
		if(conn!=null){
			conn.close();
		}
	}

}
