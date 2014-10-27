<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>用户转账主页</title>
</head>
<body>
	<h1>用户转账主页</h1>
	<a href="userSuccess.jsp">返回操作主页</a>
	<br>
	<br>

	<c:if test="${sessionScope.user==null}">
		<font color="red">你没有登陆,请重新登陆</font>
		<br>
		<a href="${pageContext.request.contextPath}/userLogin.jsp">登录</a>
	</c:if>
	
    <hr>
	<c:if test="${sessionScope.user!=null}">
			<form
			action="${pageContext.request.contextPath }/transferMoneyServlet"
			method="post">
			转账卡号：<input type="text" name="uid" /> <br>
			输入转账金额：<input type="text" name="umoney" /> 
			<input id="submit" type="submit" value="确定" />
			<font color="red">${msg}</font>
		</form>
	</c:if>
	<hr>

</body>
</html>