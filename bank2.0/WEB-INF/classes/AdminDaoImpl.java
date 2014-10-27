package com.cx.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cx.bank.model.Admin;
import com.cx.bank.util.DB;

//管理员持久层
public class AdminDaoImpl implements AdminDao {

	// 查找管理员用户
	public Admin findAdminById(String id) {

		String sql = "select * from admin where aid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Admin admin = null;

		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				admin = new Admin();
				admin.setAid(rs.getString(1));
				admin.setAname(rs.getString(2));
				admin.setApwd(rs.getString(3));
			}

		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		} finally {
			DB.closeRs(rs);
			DB.closeStmt(pstmt);
			DB.closeConn(conn);

		}

		return admin;
	}

	// 修改管理员密码
	public boolean modifyAdminPwd(String id, String pwd) {
		
		String sql = "update admin set apwd=? where aid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		

		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pwd);
			pstmt.setString(2, id);
			pstmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		
		} finally {
		
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
		return true;
	}

	// 管理员登陆
	public boolean adminLogin(String id, String pwd) {
		
		String sql = "select * from admin where aid=? and apwd=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;


		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();

			//查看集合是否有记录，判断为合法用户
			if (rs.next()) {
		     return true;
			}

		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		} finally {
			
			DB.closeRs(rs);
			DB.closeStmt(pstmt);
			DB.closeConn(conn);

		}
		
		return false;
	}

	//查询所有管理员
	public List showAllAdmin() {
		String sql = "select * from admin";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Admin> l=new ArrayList<Admin>();
        

		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Admin a=new Admin();
				a.setAid(rs.getString(1));
				a.setAname(rs.getString(2));
				a.setApwd(rs.getString(3));
				l.add(a);
			}

		

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		
		} finally {
			
			DB.closeRs(rs);
			DB.closeStmt(pstmt);
			DB.closeConn(conn);

		}
		
		return l;
		
	}

}
