<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 25-May-19
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="index.jsp"%>
<hr/>

<h3>Login Form</h3>
<%
    String profile_msg = (String)request.getAttribute("profile_msg");
    if(profile_msg != null) {
        out.print(profile_msg);
    }

    String login_msg = (String)request.getAttribute("login_msg");
    if(login_msg != null) {
        out.print(login_msg);
    }
%>
<br/>
<form action = "loginprocess.jsp" method = "post">
    Email:<input type = "text" name="username"/><br/><br/>
    Password:<input type = "password" name="password"/><br/><br/>
    <input type="submit" value="login"/>"
</form>

<jsp:forward page=""