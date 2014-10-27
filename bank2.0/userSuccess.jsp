<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>用户操作界面</title>
</head>
<body>
	<h1>用户主页</h1>
	
	<c:if test="${sessionScope.user==null}">
	  <font color="red">你没有登陆,请重新登陆</font><br>
	  <a href="${pageContext.request.contextPath}/userLogin.jsp">登录</a>
	</c:if>
	
	<c:if test="${sessionScope.user!=null}">
	欢迎回来！ <font color="blue">${sessionScope.user.uname}</font><br>
	<a href="${pageContext.request.contextPath}/userLoginOutServlet">注销</a><br>
	<hr>

	 <a href="${pageContext.request.contextPath}/modifyUserPwd.jsp">修改密码</a><br>
	 <hr>
	 <a href="${pageContext.request.contextPath}/findUserMoneyServlet">查询余额</a><br>
	 <a href="${pageContext.request.contextPath}/saveMoney.jsp">存款</a><br>
	 <a href="${pageContext.request.contextPath}/takeMoney.jsp">取款</a><br>
	 <a href="${pageContext.request.contextPath}/transferMoney.jsp">转账</a><br>
	 <hr>
	 
	</c:if>
</body>
</html>
