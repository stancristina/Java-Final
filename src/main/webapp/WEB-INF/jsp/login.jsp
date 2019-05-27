<h1  style="text-align: center; font-weight: bold">Login Page</h1>

<form action="login" method="post"  style ="text-align: center" border="3" width="60%" cellpadding="4">
    <input type = "text" name = "username" value ="username..." onclick="this.value= ''"/><br/>
    <input type="password" name="password"  value="Password..." onclick="this.value=''"/><br/>
    <input type="submit" value="Login"/>
</form>

<div>
<p>${message}</p>
</div>