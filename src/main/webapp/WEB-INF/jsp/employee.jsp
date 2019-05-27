<a href="viewemp">View Employees</a>

<h1>${command}</h1>
<form method="post" action="${action}">
    <input type = "text" name="id" style="visibility:hidden" value ="${oldEmployee.id}"/><br/>
    <input type = "text" name = "firstName" value ="${oldEmployee.firstName}" onclick="this.value= ''"/><br/>
    <input type = "text" name = "lastName" value ="${oldEmployee.lastName}" onclick="this.value= ''"/><br/>
    <input type="text" name="cnp"  value="${oldEmployee.cnp}" onclick="this.value=''"/><br/>

        <tr>
            <td> </td>
            <td colspan="2"><input type="submit" value="Save or Update" /></td>
        </tr>
    </table>
</form>