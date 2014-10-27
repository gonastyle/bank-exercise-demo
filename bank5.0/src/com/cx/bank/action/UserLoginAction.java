package com.cx.bank.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cx.bank.bll.UserManager;
import com.cx.bank.exception.AppException;
import com.cx.bank.form.UserLoginActionForm;
import com.cx.bank.model.User;

/**
 * 用户登录Action
 * 
 * @author Administrator
 * 
 */
public class UserLoginAction extends Action {

	//使用IOC注入um
	private UserManager um;
	
	public void setUm(UserManager um) {
		this.um = um;
	}

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		UserLoginActionForm laf = (UserLoginActionForm) form;
		String uid = laf.getUid();
		String upwd = laf.getUpwd();

		HttpSession session = request.getSession();

		
		User user = um.findUserById(uid);
	
		
		if (user != null) {
			if (um.userLogin(uid, upwd)) {
				
				request.getSession().setAttribute("user", user);
				
				return mapping.findForward("sucess");
			} else {
				throw new AppException("bank.passworderror");

			}
		} else {
			throw new AppException("bank.usernotfound");
	
		}
	}

}
