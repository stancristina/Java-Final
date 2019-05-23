<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form action="save" method="post">
    <input type="text" name="username" value="Name..." onclick="this.value=''"/><br/>
    <input type="password" name="password"  value="Password..." onclick="this.value=''"/><br/>

    <select name="idCompany" items="${user/companies}" itemValue="id" itemLabel="name" />

    <select>
        <c:forEach var="item" items="${obj.items}">
            <option>${item}</option>
        </c:forEach>
    </select>

    <input type="submit" value="Register"/>
</form>

<div>
    <p>${message}</p>
</div>