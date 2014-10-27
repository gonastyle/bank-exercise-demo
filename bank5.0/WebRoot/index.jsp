<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html>
	<head>
		<title>系统主页</title>
		<script language="javascript" type="text/javascript">
		function Mycheck(){
			if(myform.uid.value=="")
			{alert("卡号不能为空！！");return false;}
			if(myform.upwd.value=="")
			{alert("密码不能为空！！");return false;}
		}
			
		</script>
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
	<img src="./image/logo.gif">
	<body background="./image/bg3.jpg">
	<hr>
		<div align="center">
			<h1>
				
			</h1>
			<div>
			<strong>
				Language：
				<a href="changelang.do?lang=zh">中文</a>
				<a href="changelang.do?lang=en">English</a>
			</strong>	
				<br><br>

				<form name="myform" action="login.do" method="post"
					onSubmit="return Mycheck()">
					
					<table>
						<tr>
							<td>
								<strong><bean:message key="bank.uid" /></strong>
								:
							</td>
							<td>
								<input name="uid" type="text" />
							</td>
						</tr>
						<tr>
							<td>
								<strong><bean:message key="bank.upwd" /></strong>
								:
							</td>
							<td>
								<input name="upwd" type="password" />
							</td>
						</tr>
			</table>
					
						<table>
						<tr>
							<td>
								<input id="button1" type="submit"
									value="<bean:message key="bank.button.login"/>">
							</td>
							<td >
				<input id="button2" type="reset" value="<bean:message key="bank.button.clear"/>">
			　<a href="user/registerUser.jsp"><strong><bean:message
						key="bank.register" /></strong> </a>
							</td>
						</tr>
					</table>
					<font color="red"><strong><html:errors /></strong></font>
				</form>
			<hr>	
			</div>
		</div>
	</body>
</html>
