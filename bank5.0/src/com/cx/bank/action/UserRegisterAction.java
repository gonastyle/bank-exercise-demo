package com.cx.bank.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cx.bank.bll.UserManager;
import com.cx.bank.exception.AppException;
import com.cx.bank.form.UserRegisterActionForm;
import com.cx.bank.model.User;

public class UserRegisterAction extends Action {

	// 使用IOC注入um
	private UserManager um;

	public void setUm(UserManager um) {
		this.um = um;
	}

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		UserRegisterActionForm laf = (UserRegisterActionForm) form;
		String uid = laf.getUid();
		String upwd = laf.getUpwd();
		String name = laf.getUname();
		String uname = new String(request.getParameter("uname").getBytes(
				"ISO-8859-1"), "UTF-8");

		// 封装用户
		User u = new User();
		u.setUid(uid);
		u.setUname(uname);
		u.setUpwd(upwd);

		if (um.findUserById(uid) == null) {
			if (um.registerUser(u)) {
				
				//此异常由BankExceptionHandler处理
				throw new AppException("bank.registersuccess");
				
			} else {
				throw new AppException("bank.registerfail");
			}
		} else {
			throw new AppException("bank.idrepeat");
		}

	}
}
