<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update employees</title>
</head>
<body>
<form action="../update" method="post">
    <c:forEach var="employee" items="${employeeList}">

        Id:    	<input type="text" name="dispId" value="${employee.id}" disabled="disabled"/>
        <input type="hidden" name="id" value="${employee.id}"/>
        LastName:  	<input type="text" name="lastname" value="${employee.lastName}" />

        FirstName: 	<input type="text" name="firstName" value="${employee.firstName}" />

        Cnp:	<input type="text" name="Cnp" value="${employee.Cnp}" />

        <input type="submit" value="Update" />
    </c:forEach>
</form>
${msg}
</body>
</html>

