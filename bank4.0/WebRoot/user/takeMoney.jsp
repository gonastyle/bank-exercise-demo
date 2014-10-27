<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>用户取款主页</title>
</head>
<body>
	<h1>用户取款主页</h1>
	<a href="${pageContext.request.contextPath}/user/userSuccess.jsp">返回操作主页</a>
	<br>
	<br>

	<c:if test="${sessionScope.user==null}">
		<font color="red">你没有登陆,请重新登陆</font>
		<br>
		<a href="${pageContext.request.contextPath}/index.jsp">登录</a>
	</c:if>
	
    <hr>
	<c:if test="${sessionScope.user!=null}">
			<form
			action="${pageContext.request.contextPath }/userOperation.do?command=take"
			method="post">
			输入取款金额：<input type="text" name="umoney"> 
			<input id="submit" type="submit" value="确定" />
		</form>
		<font color="red">${msg}</font>
	</c:if>
	<hr>

</body>
</html>