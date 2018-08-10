<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration</title>
</head>
<body>
	<html:form action="/Registration" focus="userName"> 
	<table>
		<tr> 
			<td>User Name </td>
			<td><html:text property="userName" /> </td>
		</tr>
		<tr> 
			<td>Email </td>
			<td><html:text property="email" /> </td>
		</tr>
		<tr> 
			<td>Password </td>
			<td><html:text property="password" /> </td>
		</tr>
		<tr> 
			<td><html:submit value="Register" /> </td>
			<td><html:submit value="View" /> </td>
		</tr>
	</table>
	</html:form>
</body>
</html>