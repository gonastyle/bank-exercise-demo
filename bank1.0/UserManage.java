package com.cx.bank.bll;

import javax.swing.JOptionPane;

import com.cx.bank.dal.UserService;
import com.cx.bank.model.User;

public class UserManage {

	private UserService us = new UserService(); // 使用数据访问层的对象
	//保存已登陆的用户
	private User user;
	private static UserManage instance = null;

	private UserManage() {
	}

	public static UserManage getInstance() {

		if (instance == null) {

			instance = new UserManage();
			return instance;
		}

		return instance;

	}

	// 登陆-逻辑层
	public boolean login(String id, String pwd) {

		user = us.getUserById(id);

		if (user == null) {

			return false;
		}

		if (user.getPwd().equals(pwd)) {

			return true;

		} else {

			return false;
		}

	}

	// 注册新用户-逻辑层
	public boolean register(String id, String pwd) {

		if (us.Register(id, pwd)) {
			return true;
		} else {
			return false;
		}
	}

	public User getUser() {
		return this.user;
	}

	public UserService getUserService() {
		return this.us;
	}

	// 取款-逻辑层
	public boolean takeMoney(String money) {

		if (us.take(UserManage.getInstance().getUser(), money)) {
			return true;
		} else {
			return false;
		}

	}

	// 存款-逻辑层
	public boolean saveMoney(String money) {

		if (us.save(UserManage.getInstance().getUser(), money)) {
			
			return true;
		} else {
			return false;
		}
	}

	// 转账-逻辑层
	public boolean transferMoney(String id, String money) {

		User other = us.getUserById(id);
		String currid=this.user.getId();

		if(currid.equals(id)){
			JOptionPane.showMessageDialog(null, "不能转给自己", "提示",JOptionPane.OK_OPTION);
			return false;
		}
		if (other == null) {
			JOptionPane.showMessageDialog(null, "用户不存在", "提示",JOptionPane.OK_OPTION);
			return false;
		}

		if (us.transfer(UserManage.getInstance().getUser(),other, money)) {
			return true;
		} else {
			return false;
		}

	}

}
