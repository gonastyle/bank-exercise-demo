package com.cx.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cx.bank.model.User;
import com.cx.bank.util.DB;


public class UserDaoImpl implements UserDao {

	
	// 查找指定用户
	public User findUserById(String id) {
		
		String sql = "select * from user where uid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = null;

		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				user = new User();
				user.setUid(rs.getString(1));
				user.setUname(rs.getString(2));
				user.setUpwd(rs.getString(3));
				user.setUmoney(rs.getDouble(4));
			}

		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		} finally {
			DB.closeRs(rs);
			DB.closeStmt(pstmt);
			DB.closeConn(conn);

		}

		return user;
	}

	// 登录验证
	public boolean userLogin(String id, String pwd) {

		String sql = "select * from user where uid=? and upwd=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();

			// 查看集合是否有记录，判断为合法用户
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

	// 修改密码
	public boolean modifyUserPwd(String id, String pwd) {

		String sql = "update user set upwd=? where uid=?";
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

	// 查找所有用户
	public List showAllUser() {

		String sql = "select * from user";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<User> l = new ArrayList<User>();

		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				User a = new User();
				a.setUid(rs.getString(1));
				a.setUname(rs.getString(2));
				a.setUpwd(rs.getString(3));
				a.setUmoney(rs.getDouble(4));
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

	// 查询用户余额
	public Double findUserMoney(String id) {

		String sql = "select umoney from user where uid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Double money = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				money = rs.getDouble(1);
				return money;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {

			DB.closeRs(rs);
			DB.closeStmt(pstmt);
			DB.closeConn(conn);

		}

		return null;
	}

	// 取款
	public boolean takeMoney(String id, Double money) {

		// 当前余额
		Double curr = findUserMoney(id);
		// 余额符合要求
		if (curr > 0 && curr > money) {
			String sql = "update user set umoney=? where uid=?";
			Connection conn = null;
			PreparedStatement pstmt = null;

			try {
				conn = DB.getConn();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(2, id);
				pstmt.setDouble(1, curr - money);
				pstmt.executeUpdate();

			} catch (SQLException e) {

				e.printStackTrace();
				return false;

			} finally {

				DB.closeStmt(pstmt);
				DB.closeConn(conn);
			}

			return true;

		} else {

			return false;
		}

	}

	// 存款
	public boolean saveMoney(String id, Double money) {

		// 当前余额
		Double curr = findUserMoney(id);
		String sql = "update user set umoney=? where uid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(2, id);
			pstmt.setDouble(1, curr + money);
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

	// 转账
	public boolean transferMoney(String id1, String id2, Double money) {

		User u = findUserById(id2);
		if (u == null) {
			// 用户不存在
			return false;
		} else {

			takeMoney(id1, money);
			saveMoney(id2, money);
			// 转账成功
			return true;
		}
	}

	//注册
	public boolean registerUser(User u) {

		String sql = "insert into user values(?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, u.getUid());
			pstmt.setString(2, u.getUname());
			pstmt.setString(3, u.getUpwd());
			pstmt.setDouble(4, u.getUmoney());
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
}
