package com.cx.bank.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cx.bank.bll.UserManager;
import com.cx.bank.model.User;


public class UserLoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("uid");
		String pwd = request.getParameter("upwd");

		HttpSession session = request.getSession();

		UserManager am = UserManager.getInstance();
		User user= am.findUserById(id);
		if (user == null) {
			request.setAttribute("msg", "用户ID号不存在！");
			request.getRequestDispatcher("/userLogin.jsp").forward(request,
					response);
			return;
		} else {
			
			if (am.userLogin(id, pwd)) {

				session.setAttribute("user", user);
				response.sendRedirect("userSuccess.jsp");
				return;

			} else {

				request.setAttribute("msg", "密码错误！");
				request.getRequestDispatcher("/userLogin.jsp").forward(
						request, response);
				return;
			}

		}
		

	}

}
