<html>
<head>
    <title>普通用户登陆主页</title>
</head>
<body>
<center >
<h1>普通用户登陆主页</h1>
<form action="${pageContext.request.contextPath }/userLoginServlet" method="post">
用户Id号：<input  type="text" name="uid" ><br><br>
密码：<input   type="password" name="upwd" ><br><br>
<font color="red">${msg }</font><br>
<input id="submit" type="submit" value="登陆" />
&nbsp;&nbsp;
<input id="reset" type="reset" value="清空"  />
</form>
<hr>
<a href="${pageContext.request.contextPath }/registerUser.jsp">注册</a>
</body>
</html>
