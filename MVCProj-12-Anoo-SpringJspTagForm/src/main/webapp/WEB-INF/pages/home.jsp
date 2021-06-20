<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<form:form modelAttribute="stud">
	<table border="1" bgcolor="cyan" align="center">
		<tr>
			<td>Candidate No ::</td>
			<td><form:input path="no" /></td>
		</tr>
		<tr>
			<td>Candidate name ::</td>
			<td><form:input path="name" /></td>
		</tr>
		<tr>
			<td>Candidate age ::</td>
			<td><form:input path="age" /></td>
		</tr>
		<tr>
			<td>Candidate Job ::</td>
			<td><form:input path="job" /></td>
		</tr>
		<tr>
			<td><input type="submit" value="send"></td>
		</tr>

	</table>
</form:form>