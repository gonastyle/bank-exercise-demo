package com.cx.bank.model;

//模型层，用于存放数据
//普通客户
public class User {

	private String uid;// 卡号
	private String uname;// 姓名
	private String upwd;// 密码
	private double umoney;// 存款

	
	public String getUid() {
		return uid;
	}

	public String getUname() {
		return uname;
	}

	public String getUpwd() {
		return upwd;
	}

	public Double getUmoney() {
		return umoney;
	}

	
	
	public void setUid(String uid) {
		this.uid = uid;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

	public void setUmoney(double umoney) {
		this.umoney = umoney;
	}

}
