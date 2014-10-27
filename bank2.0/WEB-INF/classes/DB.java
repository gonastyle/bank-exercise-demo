package com.cx.bank.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//数据库管理工具类
public final class DB {

	
	private static DBConnManager dbm = new DBConnManager();
	private static String name = "mysql";
	
	private DB(){
		
	}
	// 从连接池或得连接，
	public static Connection getConn() {

		return dbm.getConnection(name);
	}

	//释放单个连接
	public static void closeConn(Connection conn) {

		dbm.releaseConnection("mysql", conn);
	}
	
	//关闭连接池所有连接
	public static void closeConn() {

		dbm.closeConns();
	}

	public static void closeStmt(Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void closeRs(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

}
