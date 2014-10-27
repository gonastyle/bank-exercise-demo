package com.cx.bank.dao;

import java.util.List;

import com.cx.bank.model.User;

public interface UserDao {

	// 查找是否有这人,没有返回空。
	public User findUserById(String id);

	// 根据user的值判断是否为合法用户
	public boolean userLogin(String id, String pwd);

	// 根据id号求修改对应的Admin密码
	public boolean modifyUserPwd(String id, String pwd);

	// 查找所有用户
	public List showAllUser();
	
	//用户注册
	public boolean registerUser(User u);

	// 查询余额
	public Double findUserMoney(String id);

	// 取款
	public boolean takeMoney(String id, Double money);

	// 存款
	public boolean saveMoney(String id, Double money);

	// 转账
	public boolean transferMoney(String id1, String id2, Double money);
}
