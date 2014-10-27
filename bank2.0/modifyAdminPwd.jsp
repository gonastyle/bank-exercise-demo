<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>管理员密码修改主页</title>
</head>
<body>
	<h1>管理员密码修改主页</h1>
	<br>
	<br>

	<c:if test="${sessionScope.admin==null}">
		<font color="red">你没有登陆,请重新登陆</font>
		<br>
		<a href="${pageContext.request.contextPath}/adminLogin.jsp">登录</a>
	</c:if>

	<c:if test="${sessionScope.admin!=null}">
		<form
			action="${pageContext.request.contextPath }/modifyAdminPwdServlet"
			method="post">
			新密码：<input type="password" name="upwd"> <input id="submit"
				type="submit" value="确定" />
		</form>
	</c:if>

</body>
</html>
