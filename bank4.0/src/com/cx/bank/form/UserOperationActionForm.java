package com.cx.bank.form;

import org.apache.struts.action.ActionForm;

public class UserOperationActionForm extends ActionForm {
	
	String uid;
	String upwd;
	String umoney;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public String getUmoney() {
		return umoney;
	}
	public void setUmoney(String umoney) {
		this.umoney = umoney;
	}
	
	

	
}
