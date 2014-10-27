<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html"  prefix="html"%>
<html>
	<head>
		<title>错误信息!</title>
	</head>
	<body>
		<html:errors />
		<input type="button" name="goback" value="返回" onClick=javascript: history.go(-1);>
	</body>
</html>
