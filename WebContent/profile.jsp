<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	request.getAttribute("userprofile");
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile</title>
</head>
<body>
   	<form action="UserUpdateprofile.action" method="post">
		<input name="username" 		value=<s:property value="#request.userprofile.get(0)"/>>
		<input name="password" 		value=<s:property value="#request.userprofile.get(1)"/>>
		<input name="gender" 		value=<s:property value="#request.userprofile.get(2)"/>>
		<input name="mailaddress" 	value=<s:property value="#request.userprofile.get(3)"/>>
		<input type="submit" value=Update style="height:20px;width:60px;float:main;">
	</form>
</body>
</html>