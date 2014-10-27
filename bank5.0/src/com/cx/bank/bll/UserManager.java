package com.cx.bank.bll;

import com.cx.bank.model.User;

public interface UserManager {
	
	public User findUserById(String id);

	public boolean modifyUserPwd(String id, String pwd);

	public boolean userLogin(String id, String pwd);

	public String findUserMoney(String id);

	public boolean takeMoney(String id, String money);

	public boolean saveMoney(String id, String money);

	public boolean transferMoney(String id1, String id2, String money);

	public boolean registerUser(User u);
}
