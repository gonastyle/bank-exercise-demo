<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>管理员操作界面</title>
</head>
<body>
	<h1>管理员主页</h1>
	<c:if test="${sessionScope.admin==null}">
	  <font color="red">你没有登陆,请重新登陆</font><br>
	  <a href="${pageContext.request.contextPath}/adminLogin.jsp">登录</a>
	</c:if>
	<c:if test="${sessionScope.admin!=null}">
	欢迎回来！ <font color="blue">${sessionScope.admin.aname}</font><br>
	<a href="${pageContext.request.contextPath}/adminLoginOutServlet">注销</a><br>
	<hr>
	 <a href="${pageContext.request.contextPath}/showAllAdminServlet">显示其它管理员</a><br>
	 <a href="${pageContext.request.contextPath}/showAllUserServlet">显示所有用户</a><br>
	 <a href="${pageContext.request.contextPath}/modifyAdminPwd.jsp">修改密码</a><br>
	 <hr>
	</c:if>
</body>
</html>
