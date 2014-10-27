package com.cx.bank.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import com.cx.bank.bll.UserManager;
import com.cx.bank.exception.AppException;
import com.cx.bank.form.UserLoginActionForm;
import com.cx.bank.model.User;

/**
 * ÓÃ»§µÇÂ¼Action
 * 
 * @author Administrator
 * 
 */
public class UserLoginAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		UserLoginActionForm laf = (UserLoginActionForm) form;
		String uid = laf.getUid();
		String upwd = laf.getUpwd();

		HttpSession session = request.getSession();

		UserManager am = UserManager.getInstance();
		User user = am.findUserById(uid);
		System.out.println(uid+upwd+user.getUmoney());
		
		if (user != null) {
			if (am.userLogin(uid, upwd)) {
				
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
