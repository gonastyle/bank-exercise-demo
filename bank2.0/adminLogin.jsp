
<html>
<head>
    <title>管理员登陆主页</title>
</head>
<body>
<h1>管理员登陆主页</h1>
<br><br>

<form action="${pageContext.request.contextPath }/adminLoginServlet" method="post" >
用户名：<input  type="text" name="uid" ><br><br>
密码：<input   type="password" name="upwd" ><br><br>
<font color="red">${msg }</font><br>
<input id="submit" type="submit" value="登录" />
&nbsp;&nbsp;
<input id="reset" type="reset" value="清空"  />
</form>
</body>
</html>
