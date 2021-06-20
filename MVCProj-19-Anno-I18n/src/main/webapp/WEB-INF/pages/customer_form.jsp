<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="c" %>

<h1 style="color:red;text-align:center"><spring:message code="customer.title"/></h1>

<form:form modelAttribute="cust">
	<table border="1" bgcolor="center" align ="center">
		<tr>
		<td><spring:message code="customer.name"/></td>
		<td><form:input path="name"/></td>
		</tr>
		<tr>
		<td><spring:message code="customer.addrs"/></td>
		<td><form:input path="addrs"/></td>
		</tr>
		<tr>
		<td><spring:message code="customer.billAmt"/></td>
		<td><form:input path="billAmt"/></td>
		</tr>
		
		<tr>
		<td colspan="2" ><input type="submit" value="<spring:message code="customer.submit"/>"></td>
		</tr>
	</table>
</form:form>
<br><br>
<a href="?lang=de_DE">German</a> &nbsp;&nbsp;
<a href="?lang=in_IN">Hindi</a> &nbsp;&nbsp;
<a href="?lang=en_US">English</a> &nbsp;&nbsp;
<a href="?lang=zh_CN">Chinese</a> &nbsp;&nbsp;
<a href="?lang=fr_FR">French</a> &nbsp;&nbsp;