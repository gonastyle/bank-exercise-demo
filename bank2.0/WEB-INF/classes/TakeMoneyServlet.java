package com.cx.bank.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cx.bank.bll.UserManager;
import com.cx.bank.model.User;

public class TakeMoneyServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserManager am = UserManager.getInstance();
		String money = request.getParameter("umoney");
		User u = (User) request.getSession().getAttribute("user");

		// 防止注销后访问这个servlet
		if (u != null) {
			String id = u.getUid();
			if (am.takeMoney(id, money)) {
				// 修改成功跳转到主页
				request.setAttribute("msg", "取款款成功");
				request.getRequestDispatcher("/takeMoney.jsp").forward(request,
						response);
				return;
			} else {
				request.setAttribute("msg", "系统出错或余额不足");
				request.getRequestDispatcher("/takeMoney.jsp").forward(request,
						response);
				return;
			}

		}else{
			
			return;
		}
		
	}


}
