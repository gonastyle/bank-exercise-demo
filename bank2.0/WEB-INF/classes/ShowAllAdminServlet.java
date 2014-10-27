package com.cx.bank.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cx.bank.bll.AdminManager;

public class ShowAllAdminServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		AdminManager am = AdminManager.getInstance();
		
		List l=am.showAllAdmin();
		if(l==null){
			request.setAttribute("msg","没有其它用户！");
			request.getRequestDispatcher("/adminList.jsp").forward(request,
					response);
			return;
		}else{
			request.setAttribute("adminlist",l);
			request.getRequestDispatcher("/adminList.jsp").forward(request,
					response);
			return;
		}
		
	}

}
