<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>普通用户注册主页</title>
</head>
<body>
<h1>普通用户注册主页</h1>
<a href="${pageContext.request.contextPath }/userLogin.jsp">返回登陆主页</a>
<form action="${pageContext.request.contextPath }/registerUserServlet" method="post">
用户Id号：<input  type="text" name="uid" ><br><br>
用户姓名：<input  type="text" name="uname" ><br><br>
密码：<input   type="password" name="upwd" ><br><br>
<font color="red">${msg }</font><br>

<input id="submit" type="submit" value="确认" />
&nbsp;&nbsp;
<input id="reset" type="reset" value="清空"  />
</form>
</body>
</html>
