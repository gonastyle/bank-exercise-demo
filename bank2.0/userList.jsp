<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>普通用户</title>
  </head>
  <body>
  <h1>普通户列表</h1>
  <c:if test="${sessionScope.admin==null}">
	  <font color="red">你没有登陆,请重新登陆</font><br>
	  <a href="${pageContext.request.contextPath}/adminLogin.jsp">登录</a>
  </c:if>
  
  <c:if test="${sessionScope.admin!=null}">

  <table border="1">
		<tr>
			<td>卡号</td>
			<td>姓名</td>
			<td>密码</td>
			<td>余额</td>
		</tr>
		<c:choose>
			<c:when test="${empty requestScope.userlist}">
				<tr>
					<td colspan="3">${requestScope.userlist.msg}</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${requestScope.userlist}" var="user" varStatus="vs">
					<c:choose>
						<c:when test="${vs.count % 2 == 0}">
							<tr bgcolor="red">
						</c:when>
						<c:otherwise>
							<tr>
						</c:otherwise>
					</c:choose>
								<td>
									<c:out value="${user.uid}"/>
								</td>
								<td>
									<c:out value="${user.uname}"/>
								</td>
								<td>
									<c:out value="${user.upwd}"/>
								</td>
								<td>
									<c:out value="${user.umoney}"/>
								</td>
						</tr>		
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
  
  </c:if>

  
  </body>
</html>
