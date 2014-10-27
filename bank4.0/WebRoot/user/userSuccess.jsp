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
	  <a href="${pageContext.request.contextPath}/index.jsp">登录</a>
	</c:if>
	
	<c:if test="${sessionScope.user!=null}">
	欢迎回来！ <font color="blue">${sessionScope.user.uname}</font><br>
	<a href="${pageContext.request.contextPath}/loginout.do">注销</a><br>
	<hr>

	 <a href="${pageContext.request.contextPath}/user/modifyUserPwd.jsp">修改密码</a><br>
	 <hr>
	 <a href="${pageContext.request.contextPath}/userOperation.do?command=find">查询余额</a><br>
	 <a href="${pageContext.request.contextPath}/user/saveMoney.jsp">存款</a><br>
	 <a href="${pageContext.request.contextPath}/user/takeMoney.jsp">取款</a><br>
	 <a href="${pageContext.request.contextPath}/user/transferMoney.jsp">转账</a><br>
	 <hr>
	 
	</c:if>
</body>
</html>
