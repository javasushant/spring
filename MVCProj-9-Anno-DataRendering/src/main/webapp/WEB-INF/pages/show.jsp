<%@page import="java.util.*"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
Nmae :: ${name} Age :: ${age} DTO : ${dtoval}
<br>
List : ${l}
<br>
city name : ${city}
<br>
result : ${result}
<br>
food item : ${food[0]}..${food[1]}.. ${food[2]}
<br>
<%=Arrays.toString((String[]) request.getAttribute("food"))%>
<br>
<c:forEach var="fod" items="${food}">
	<c:out value="${fod}.."></c:out>
</c:forEach>