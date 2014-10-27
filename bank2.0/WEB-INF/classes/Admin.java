package com.cx.bank.model;

//模型层，用于存放数据
/*
数据格式限制
10,10,6//admin
20,10,6,（11,2）//user
*/

public class Admin {

	private String aid;// 工号
	private String aname;// 姓名
	private String apwd;// 密码

	public String getAid() {
		return aid;
	}

	public String getAname() {
		return aname;
	}

	public String getApwd() {
		return apwd;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public void setApwd(String apwd) {
		this.apwd = apwd;
	}

}
