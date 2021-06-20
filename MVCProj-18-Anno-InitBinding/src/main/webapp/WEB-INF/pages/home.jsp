<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h1 style="color: green; text-align: center">Customer Registration
	Form</h1>
<form:form modelAttribute="cust">
	<table align="center" bgcolor="cyan">
		<tr>
			<td>Customer name::</td>
			<td><form:input path="cname" /></td>
		</tr>
		<tr>
			<td>Customer address::</td>
			<td><form:input path="cadd" /></td>
		</tr>
		<tr>
			<td>Customer billAmt::</td>
			<td><form:input path="billAmt" /></td>
		</tr>
		<tr>
			<td>Gender</td>
			<td><form:radiobuttons path="gender" items="${genderList}" /></td>
		</tr>
		<tr>
			<td>Hobbies</td>
			<td><form:checkboxes path="hobbies" items="${listHobbies}" /></td>
		</tr>
		<tr>
			<td>Select Country Name</td>
			<td><form:select path="country">
					<form:options items="${listCountries}" />
				</form:select></td>
		</tr>
		<tr>
			<td>Select Language Name</td>
			<td><form:select path="lang" multiple="multiple">
					<form:options items="${LangList}" />
				</form:select></td>
		</tr>
	
			<tr>
		<td>DOB ::</td>
		<td><form:input type="date" path="dob"/></td>
		</tr>
		<tr>
		<td>DOJ ::</td>
		<td><form:input type="date" path="doj"/></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="register" height="30" width="40"></td>
		</tr>



	</table>
</form:form>