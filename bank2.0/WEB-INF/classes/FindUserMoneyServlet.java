package com.cx.bank.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cx.bank.bll.UserManager;
import com.cx.bank.model.User;

public class FindUserMoneyServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		  doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserManager am = UserManager.getInstance();
		User u=(User)request.getSession().getAttribute("user");
		
		//防止注销后访问这个servlet
		if(u!=null){
			String id=u.getUid();
		    String money=am.findUserMoney(id);
		    if(money==null){
		    	response.sendRedirect("error.jsp");
				return;
		    }
		    request.setAttribute("money",money);
		    request.getRequestDispatcher("/findUserMoney.jsp").forward(request,
					response);
		    
		}else{
			response.sendRedirect("error.jsp");
			return;
		}
		
	}


}
