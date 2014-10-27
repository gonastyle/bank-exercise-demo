<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html>
<head>
<title>用户操作界面</title>
</head>
<body background="./image/07.jpg">
	<h1><bean:message key="user.page"/></h1>
	
	<c:if test="${sessionScope.user==null}">
		<font color="red"><bean:message key="usernotlogin"/></font>
		<br>
		<a href="${pageContext.request.contextPath}/index.jsp"><bean:message key="bank.button.login"/></a>
	</c:if>
	
	<c:if test="${sessionScope.user!=null}">
	<bean:message key="welcome"/> <font color="blue">${sessionScope.user.uname}</font><br>
	<a href="${pageContext.request.contextPath}/loginout.do"><bean:message key="loginout"/></a><br>
	<hr>

	 <a href="${pageContext.request.contextPath}/user/modifyUserPwd.jsp"><bean:message key="changepassword"/></a><br>
	 <hr>
	 <a href="${pageContext.request.contextPath}/userOperation.do?command=find"><bean:message key="findmoney"/></a><br>
	 <a href="${pageContext.request.contextPath}/user/saveMoney.jsp"><bean:message key="savemoney"/></a><br>
	 <a href="${pageContext.request.contextPath}/user/takeMoney.jsp"><bean:message key="takemoney"/></a><br>
	 <a href="${pageContext.request.contextPath}/user/transferMoney.jsp"><bean:message key="transfermoney"/></a><br>
	 <hr>
	 
	</c:if>
</body>
</html>
