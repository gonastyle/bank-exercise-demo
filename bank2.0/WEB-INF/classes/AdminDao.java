package com.cx.bank.dao;

import java.util.List;

import com.cx.bank.model.Admin;

public interface AdminDao {

	// 管理员的id号。查找是否有这人,没有返回空。
	public Admin findAdminById(String id);

	// 根据admin的值判断是否为合法用户
	public boolean adminLogin(String id, String pwd);

	//根据id号求修改对应的Admin密码
	public boolean modifyAdminPwd(String id,String pwd);
	
	//显示所有管理员
	public List showAllAdmin();
	
	
	

}
