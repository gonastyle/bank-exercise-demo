<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html>
<head>
<title>用户转账主页</title>
<script language="javascript" type="text/javascript">
		function Mycheck(){
			if(myform.uid.value=="")
			{alert("转入帐号不能为空！！");return false;}
			if(myform.umoney.value=="")
			{alert("转出金额不能为空！！");return false;}
			
		}			
		</script>

</head>
<body background="./image/bg3.jpg">
	<h1><bean:message key="user.transfer.page"/></h1>
	<br>
	<br>
	<a href="${pageContext.request.contextPath}/user/userSuccess.jsp"><bean:message key="bank.return"/></a>
	<c:if test="${sessionScope.user==null}">
		<font color="red"><bean:message key="usernotlogin"/></font>
		<br>
		<a href="${pageContext.request.contextPath}/index.jsp"><bean:message key="bank.button.login"/></a>
	</c:if>
	
    <hr>
	<c:if test="${sessionScope.user!=null}">
			<form
			action="${pageContext.request.contextPath }/userOperation.do?command=transfer"
			method="post" name="myform" onSubmit="return Mycheck()">
			<table >
			<tr><td><bean:message key="transfer.number"/>：</td><td><input type="text" name="uid" /></td></tr>
			<tr><td><bean:message key="input.transfer.money"/>：</td><td><input type="text" name="umoney" /></td></tr>
			<tr><td colspan="2"><input id="submit" type="submit" value="<bean:message key="user.ok"/>" /></td></tr>
			</table>
			<font color="red">${msg}</font>
		</form>
	</c:if>
	<hr>

</body>
</html>