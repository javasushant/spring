<%@ page isELIgnored="false"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<head>
<title><tiles:insertAttribute name='title' ignore="true" /></title>
</head>
<table border="1" width="100%" height="100%">
	<tr height="20%" bgcolor="yellow">
		<td colspan="3" ><tiles:insertAttribute name="header" /></td>
	</tr>
	
	<tr height="70%">
		<td width="30%" bgcolor="orange"><tiles:insertAttribute
				name="menu" /></td>
		<td width="60%" bgcolor="cyan"><tiles:insertAttribute
				name="body" /></td>
		<td width="10%" bgcolor="red"><tiles:insertAttribute name="news" /></td>
	</tr>
	
	<tr height="10%" bgcolor="blue">
		<td  colspan="3"><tiles:insertDefinition name="footer" /></td>
	</tr>
</table>

