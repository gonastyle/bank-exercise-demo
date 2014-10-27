<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
  <head>  
    <title>用户注册界面</title>
  </head>

  <body>
  <div align="center">
  <h1>用户注册界面</h1>
  <form action="${pageContext.request.contextPath }/register.do" method="post"><br>
   卡号：<input type="text" name="uid" /><br>
   姓名：<input type="text" name="uname" /><br>
   密码：<input type="password" name="upwd" /><br>
   <input type="submit" value="确认" />
   <input type="reset" value="清空" />
  </form>
  
  </div>
  </body>
</html>
