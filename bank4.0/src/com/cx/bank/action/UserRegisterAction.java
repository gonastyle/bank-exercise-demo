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
import com.cx.bank.form.UserRegisterActionForm;
import com.cx.bank.model.User;

public class UserRegisterAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserRegisterActionForm laf = (UserRegisterActionForm) form;
		String uid = laf.getUid();
		//String uname=laf.getUname();
		String upwd = laf.getUpwd();
		String uname = new String(request.getParameter("uname").getBytes("ISO-8859-1"),"UTF-8") ;
		System.out.println(uname);
		UserManager am = UserManager.getInstance();
        User u=new User();
        u.setUid(uid);
        u.setUname(uname);
        u.setUpwd(upwd);
			if (am.registerUser(u)) {
				
				throw new AppException("bank.registersuccess");
			} else {
				throw new AppException("bank.registerfail");
		}
	}

}
