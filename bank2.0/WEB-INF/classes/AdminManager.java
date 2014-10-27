package com.cx.bank.bll;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.cx.bank.factory.AdminDaoFactory;
import com.cx.bank.model.Admin;

//业务逻辑层，管理Admin的数据，使用单例，饱汉模式。
public class AdminManager {

	private static AdminManager instance = new AdminManager();

	public static AdminManager getInstance() {
		return instance;
	}


	//查找
	public Admin findAdminById(String id) {

		return AdminDaoFactory.getInstance().createAdminDao().findAdminById(id);

	}

	//修改密码
	public boolean modifyAdminPwd(String id, String pwd) {

		return AdminDaoFactory.getInstance().createAdminDao()
				.modifyAdminPwd(id, pwd);

	}

	//登陆
	public boolean adminLogin(String id, String pwd) {
		return AdminDaoFactory.getInstance().createAdminDao()
				.adminLogin(id, pwd);
	}
	
	//显示所有管理员
	public List showAllAdmin(){
		return AdminDaoFactory.getInstance().createAdminDao().showAllAdmin();
	}

}
