package com.cx.bank.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cx.bank.bll.UserManager;
import com.cx.bank.model.User;

public class ModifyUserPwdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		UserManager am = UserManager.getInstance();
		String pwd=request.getParameter("upwd");
		User u=(User)request.getSession().getAttribute("user");
		
		//防止注销后访问这个servlet
		if(u!=null){
			String id=u.getUid();
			if(am.modifyUserPwd(id, pwd)){
				//修改成功跳转到主页
				request.getRequestDispatcher("/userSuccess.jsp").forward(
						request, response);
				return;
			}else{
				
				response.sendRedirect("error.jsp");
				return;
			}
			
		}
		
	

	}

}
