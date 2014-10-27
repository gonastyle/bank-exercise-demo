package com.cx.bank.bll;

import java.io.UnsupportedEncodingException;
import java.util.List;
import com.cx.bank.factory.UserDaoFactory;
import com.cx.bank.model.User;

//业务逻辑层，管理user的数据
public class UserManager {
	private static UserManager instance = new UserManager();

	public static UserManager getInstance() {
		return instance;
	}


	// 查找
	public User findUserById(String id) {

		return UserDaoFactory.getInstance().createUserDao().findUserById(id);

	}

	// 修改密码
	public boolean modifyUserPwd(String id, String pwd) {

		return UserDaoFactory.getInstance().createUserDao()
				.modifyUserPwd(id, pwd);

	}

	// 登陆
	public boolean userLogin(String id, String pwd) {
		return UserDaoFactory.getInstance().createUserDao().userLogin(id, pwd);
	}

	// 显示所有用户
	public List showAllUser() {
		return UserDaoFactory.getInstance().createUserDao().showAllUser();
	}

	// 查询余额
	public String findUserMoney(String id) {

		Double m = UserDaoFactory.getInstance().createUserDao()
				.findUserMoney(id);
		if (m != null) {
			String money = String.valueOf(m);
			return money;
		} else {
			return null;
		}
	}

	// 取款
	public boolean takeMoney(String id, String money) {

		try {
			Double m = Double.valueOf(money);
			return UserDaoFactory.getInstance().createUserDao()
					.takeMoney(id, m);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return false;
		}

	}

	// 存款
	public boolean saveMoney(String id, String money) {
		try {
			Double m = Double.valueOf(money);
			return UserDaoFactory.getInstance().createUserDao()
					.saveMoney(id, m);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return false;
		}
	}

	// 转账
	public boolean transferMoney(String id1, String id2, String money) {
		try {
			Double m = Double.valueOf(money);
			return UserDaoFactory.getInstance().createUserDao()
					.transferMoney(id1, id2, m);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//注册
	public boolean registerUser(User u) {
	
		return UserDaoFactory.getInstance().createUserDao().registerUser(u);
	}
	

}
