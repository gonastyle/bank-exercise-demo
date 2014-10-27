package com.cx.bank.factory;

import com.cx.bank.dao.AdminDao;
import com.cx.bank.dao.AdminDaoImpl;

// 产生数据访问层层管理对象，支持同步访问数据库，线程安全
public class AdminDaoFactory {

	private static AdminDaoFactory instance;
	private AdminDao adminDao;

	private AdminDaoFactory() {
		adminDao = new AdminDaoImpl();
	}

	public static synchronized AdminDaoFactory getInstance() {

		if (instance == null) {
			instance = new AdminDaoFactory();
		}

		return instance;
	}

	public AdminDao createAdminDao() {
		return adminDao;
	}

}
