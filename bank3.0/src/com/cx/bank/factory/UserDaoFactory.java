package com.cx.bank.factory;

import com.cx.bank.dao.UserDao;
import com.cx.bank.dao.UserDaoImpl;

//产生数据访问层层管理对象，支持同步访问数据库，线程安全
public class UserDaoFactory {

	private static UserDaoFactory instance;
	private UserDao userDao;

	private UserDaoFactory() {
		userDao = new UserDaoImpl();
	}

	public static synchronized UserDaoFactory getInstance() {

		if (instance == null) {
			instance = new UserDaoFactory();
		}

		return instance;
	}

	public UserDao createUserDao() {
		return userDao;
	}

}
