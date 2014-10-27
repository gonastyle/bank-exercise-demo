<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html>
  <head>  
    <title>用户注册界面</title>
    
    <script language="javascript" type="text/javascript">
		function Mycheck(){
			if(myform.uid.value=="")
			{alert("卡号不能为空！！");return false;}
			if(myform.uname.value=="")
			{alert("姓名不能为空！！");return false;}
			if(myform.upwd.value=="")
			{alert("密码不能为空！！");return false;}
		}
			
		</script>
    <style type="text/css">
      .font {
            font-size: 12pt;
        }
    </style>
    <style type="text/css">
        #button1,#button2 {
            color: #000066;
            height: 40px;
            width: 80px;
            text-align: center;
            font-size: larger;
            font-weight: 700;
            background-color: #FF3535;
        }
    </style>
  </head>

<body background="./image/bg3.jpg" class="font">
  <div align="center">
  <h1><bean:message key="user.reg.page"/></h1>
  
  <form action="${pageContext.request.contextPath }/register.do" method="post" name="myform" onSubmit="return Mycheck()"><br>
  <strong><bean:message key="bank.uid"/>：</strong><input type="text" name="uid" /><br>
   <strong><bean:message key="bank.name"/>：</strong><input type="text" name="uname" /><br>
   <strong><bean:message key="bank.upwd"/>：</strong><input type="password" name="upwd" /><br>
   
   <input id="button1" type="submit" value="<bean:message key="user.ok"/>" />
   <input id="button2" type="reset" value="<bean:message key="bank.button.clear"/>" />
  </form>
  
  </div>
  </body>
</html>
