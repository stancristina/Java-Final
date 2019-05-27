<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="holidayEdit" method="post">
    <form action="holidayDelete" method="post">

        <h1>Holidays List</h1>
        <table border="2" width="70%" cellpadding="2">
            <tr><th>id</th><th>startDate</th><th>endDate</th><th>idEmployee</th></td><td>Edit</th><th>Delete</th></tr>
            <c:forEach var="holiday" items="${holidayList}">
                <tr>
                    <td>${holiday.id}</td>
                    <td>${holiday.startDate}</td>
                    <td>${holiday.endDate}</td>
                    <td>${holiday.idEmployee}</td>
                    <td><a href="holidayEdit${holiday.id}">Edit</a></td>
                    <td><a href="holidayDelete/${holiday.id}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
        <br/>
        <a href="holiday">Add New Holiday</a>
    </form>
</form>