<a href="viewemp" style="color: darkblue; font-weight: bold" >View Employees</a>
<h1  style ="text-align: center">${command}</h1>
<form method="post" action="${action}" style ="text-align: center ">


    <input type = "text" name="id" style="visibility:hidden" value ="${oldEmployee.id}"/><br/>
    <input type = "text" name = "firstName" value ="${oldEmployee.firstName}" onclick="this.value= ''"/><br/>
    <input type = "text" name = "lastName" value ="${oldEmployee.lastName}" onclick="this.value= ''"/><br/>
    <input type="text" name="cnp"  value="${oldEmployee.cnp}" onclick="this.value=''"/><br/>

        <tr>
            <td> </td>
            <td colspan="3"><input type="submit" value="Save or Update"  /></td>
        </tr>
    </table>
</form>
</form>