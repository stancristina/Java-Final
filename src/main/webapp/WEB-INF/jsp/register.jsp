<form action="save" method="post">
    <input type="text" name="username" value="Username..." onclick="this.value=''"/><br/>
    <input type="password" name="password"  value="Password..." onclick="this.value=''"/><br/>
    <input type="text" name="companyName" value="Company Name..." onclick="this.value=''"/><br/>

    <input type="submit" value="Register"/>
</form>

<div>
    <p>${message}</p>
</div>