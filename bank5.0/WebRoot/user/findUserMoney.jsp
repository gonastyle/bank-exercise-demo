<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<html>
<head>
<title>用户余额主页</title>



</head>
<body background="./image/bg3.jpg">
	<h1><bean:message key="balance.page"/></h1>
	<a href="${pageContext.request.contextPath}/user/userSuccess.jsp"><bean:message key="bank.return"/></a>
	<br>
	<br>

	<c:if test="${sessionScope.user==null}">
		<font color="red"><bean:message key="usernotlogin"/></font>
		<br>
		<a href="${pageContext.request.contextPath}/index.jsp"><bean:message key="bank.button.login"/></a>
	</c:if>
	
    <hr>
	<c:if test="${sessionScope.user!=null}">
			<font color="green"><bean:message key="user.balance"/>：${requestScope.money}</font>
		
	</c:if>
	<hr>

</body>
</html>