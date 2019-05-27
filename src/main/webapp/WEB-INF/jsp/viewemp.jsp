<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<a href="employee" style="color: darkblue; font-weight: bold; text-align: center" >Add New Employee</a>

<form action="viewemp" method="get" style ="text-align: center">
    <input type="text" name="filter" value="">
    <input type="submit" value="Filter">
</form>

<h1 style="text-align: center">Employees List</h1>
<table border="3" width="60%" cellpadding="4" style="margin: 0 auto">
    <tr><th>Id</th><th>FirstName</th><th>LastName</th><th>Cnp</th></td><td>Edit</th><th>Delete</th></tr>
    <c:forEach var="employee" items="${employeeList}">
        <tr>
            <td>${employee.id}</td>
            <td>${employee.firstName}</td>
            <td>${employee.lastName}</td>
            <td>${employee.cnp}</td>
            <td><a href="editemp/${employee.id}" >Edit</a></td>
            <td><a href="deleteemp/${employee.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<br/>
    </form>
</form>