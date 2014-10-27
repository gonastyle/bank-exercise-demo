<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html>
<head>
<title>用户密码修改主页</title>

<script language="javascript" type="text/javascript">
		function Mycheck(){
			if(myform.upwd.value=="")
			{alert("密码不能为空！！");return false;}
		}
			
		</script>
</head>
<body background="./image/bg3.jpg">
	<h1>用户密码修改主页</h1>
	<br>
	<br>
<a href="${pageContext.request.contextPath}/user/userSuccess.jsp"><bean:message key="bank.return"/></a>

	<c:if test="${sessionScope.user==null}">
		<font color="red"><bean:message key="usernotlogin"/></font>
		<br>
		<a href="${pageContext.request.contextPath}/index.jsp"><bean:message key="bank.button.login"/></a>
	</c:if>

	<c:if test="${sessionScope.user!=null}">
		<form
			action="${pageContext.request.contextPath }/userOperation.do?command=modify"
			method="post" name="myform" onSubmit="return Mycheck()">
			<bean:message key="newpassword"/>：<input type="password" name="upwd"> <input id="submit"
				type="submit" value="<bean:message key="user.ok"/>" />
		</form>
		<font color="red">${msg}</font>
	</c:if>

</body>
</html>
