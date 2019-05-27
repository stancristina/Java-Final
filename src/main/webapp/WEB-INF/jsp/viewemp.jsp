<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="editemp" method="post">
    <form action="deleteemp" method="post">

<h1>Employees List</h1>
<table border="2" width="70%" cellpadding="2">
    <tr><th>Id</th><th>firstName</th><th>lastName</th><th>Cnp</th></td><td>Edit</th><th>Delete</th></tr>
    <c:forEach var="employee" items="${employeeList}">
        <tr>
            <td>${employee.id}</td>
            <td>${employee.firstName}</td>
            <td>${employee.lastName}</td>
            <td>${employee.cnp}</td>
            <td><a href="editemp/${employee.id}">Edit</a></td>
            <td><a href="deleteemp/${employee.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="employee">Add New Employee</a>
    </form>
</form>