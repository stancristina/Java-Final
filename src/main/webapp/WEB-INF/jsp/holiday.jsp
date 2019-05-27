<a href="holidayView">View Holidays</a>

<h1>${command}</h1>
<form method="post" action="${action}">
    <input type = "text" name="id" style="visibility:hidden" value ="${Holiday.id}"/><br/>
    <input type = "text" name = "startDate" value ="${Holiday.startDate}" onclick="this.value= ''"/><br/>
    <input type = "text" name = "endDate" value ="${Holiday.endDate}" onclick="this.value= ''"/><br/>
    <input type = "text" name="idEmployee"  value="${Holiday.idEmployee}" onclick="this.value=''"/><br/>

    <tr>
        <td> </td>
        <td colspan="2"><input type="submit" value="Save or Update" /></td>
    </tr>
    </table>
</form>