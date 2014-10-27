<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>管理员成员</title>
</head>
<body>
	<h1>管理员列表</h1>
	<c:if test="${sessionScope.admin==null}">
		<font color="red">你没有登陆,请重新登陆</font>
		<br>
		<a href="${pageContext.request.contextPath}/adminLogin.jsp">登录</a>
	</c:if>

	<c:if test="${sessionScope.admin!=null}">

		<table border="1">
			<tr>
				<td>工号</td>
				<td>姓名</td>
				<td>密码</td>
			</tr>

			<c:choose>
				<c:when test="${empty requestScope.adminlist}">
					<tr>
						<td colspan="3">${requestScope.adminlist.msg}</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${requestScope.adminlist}" var="admin"
						varStatus="vs">
						<c:choose>
							<c:when test="${vs.count % 2 == 0}">
								<tr bgcolor="red">
							</c:when>
							<c:otherwise>
								<tr>
							</c:otherwise>
						</c:choose>
						<td><c:out value="${admin.aid}" /></td>
						<td><c:out value="${admin.aname}" /></td>
						<td><c:out value="${admin.apwd}" /></td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>

	</c:if>


</body>
</html>
