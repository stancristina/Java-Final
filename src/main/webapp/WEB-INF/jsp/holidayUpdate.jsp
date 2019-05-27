<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Holiday</title>
</head>
<body>
<form action="../update" method="post">
    <c:forEach var="holiday" items="${holidayList}">

        Id:    	<input type="text" name="dispId" value="${holiday.id}" disabled="disabled"/>
        <input type="hidden" name="id" value="${holiday.id}"/>
        StartDate:  	<input type="text" name="startDate" value="${holiday.startDate}" />

        EndDate: 	<input type="text" name="endDate" value="${holiday.endDate}" />

        IdEmployee:	<input type="text" name="idEmployee" value="${holiday.idEmployee}" />

        <input type="submit" value="Update" />
    </c:forEach>
</form>
${msg}
</body>
</html>

