<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 25-May-19
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@page import ="application.model.LoginDao"%>
<jsp:useBean id="obj" class= "application.model.User"/>

<jsp:setProperty property="*" name="obj"/>

<%
    boolean status = LoginDao.validate(obj);
    if (status) {
        out.println("You are successfully logged in");
        session.setAttribute("session", "TRUE");
    }
    else
    {
        out.print("Username or Password Error");

%>

<jsp:include page = "index.jsp"></jsp:include>
<%
    }
%>