<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>  
<html>
  <head>
    <title>系统主页</title>
  </head>
  <body>
  <div align="center">
   <h1>银行管理系统v3.0(Struts)</h1>
   <br/>Language：
   <a href="changelang.do?lang=zh">中文</a>
   <a href="changelang.do?lang=en">English</a><br>
   
  <form name="form" action="login.do" method="post">
  <table>
  <tr>
  <td><bean:message key="bank.uid"/> ：</td>
  <td><input name="uid" type="text" /></td>
  </tr>
  <tr>
  <td><bean:message key="bank.upwd"/> ：</td>
  <td> <input name="upwd" type="password" /></td>
  </tr>
  </table>
  <font color="red"><html:errors/></font>
  <br>
  <input type="submit" value="<bean:message key="bank.button.login"/>" >  &nbsp;&nbsp;
  <input type="reset" value="<bean:message key="bank.button.clear"/>" ><br>  
  </form>
  <hr>
  <a href="user/registerUser.jsp"><bean:message key="bank.register"/></a>
  </div>
  </body>
</html>
