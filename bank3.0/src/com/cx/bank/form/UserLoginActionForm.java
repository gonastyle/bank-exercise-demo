package com.cx.bank.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * 收集表单数据的ActionForm，ActionForm中的属性必须与html中表单中的name名称一致
 * @author Administrator
 *
 */
public class UserLoginActionForm extends ActionForm {

	private String uid;
	
	private String upwd;

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

	
	
}
