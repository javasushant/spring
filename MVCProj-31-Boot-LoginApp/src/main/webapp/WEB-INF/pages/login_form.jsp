
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form:form modelAttribute="userform">
<table bgcolor="cyan" align="center">
<tr>
<td> LOgin username :: </td>
<td><form:input path="username"/>
</tr>
<tr>
<td> LOgin Password :: </td>
<td><form:input path="password"/>
</tr>
<tr><td><input type="submit" value="Login"></td></tr>
</table>
</form:form>


<br><br>
<c:if test="${!empty resultMsg }" >
<h1 style="color:red">Result is ::${resultMsg} </h1>
</c:if>