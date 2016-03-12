<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Hello World</title>
</head>
<body>
   <h1>Hello World From BookStore</h1>
   <form action="login.action" method="post">
      <label for="username">Please enter your username and password</label><br/>
      <input type="text" name="username"/>
      <input type="text" name="password"/>
      <input type="submit" value="Sign in"/>
   </form>
</body>
</html>