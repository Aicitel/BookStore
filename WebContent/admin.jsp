<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	request.getAttribute("booklist");
	request.getAttribute("userlist");
	request.getAttribute("entrylist");
	request.setAttribute("bookiter",(int)0);
	request.setAttribute("useriter",(int)0);
	request.setAttribute("entryiter",(int)0);
	
%>

<html>
<head>
<title>main</title>
</head>
<body>
	Hello World, <s:property value="username"/>,<s:property value="password"/>
	
	<form action="LogOut.action" method="get">
		<input type="submit" value="Logout" style="height:20px;width:60px;float:main;" >
	</form>
	
	<div style="overflow-x: auto; overflow-y: auto; height: 250px; width:500px;">
		<table border="1" >
        <s:iterator value="#request.booklist" status="stuts" id="iter">
        	<tr>  
        	<td>
        	<form action="RootUpdatebook.action" method="post">
				<td><input type="submit" value="update" style="height:20px;width:60px;float:main;" ></td>
				<td><input name="bookid" value=<s:property value="#request.booklist.get(#request.bookiter).get(0)"/>></td>	
	            <td><input name="bookname" value=<s:property value="#request.booklist.get(#request.bookiter).get(1)"/>></td>
	            <td><input name="bookprice" value=<s:property value="#request.booklist.get(#request.bookiter).get(2)"/>></td>
	           	<td><input name="bookcount" value=<s:property value="#request.booklist.get(#request.bookiter).get(3)"/>></td>
	        </form>
	        </td>
            </tr>
            <% request.setAttribute("bookiter",(int)request.getAttribute("bookiter")+1); %>
        </s:iterator>
    </table>
	</div>
    <br>
    <br>
	
	User
	<div style="overflow-x: auto; overflow-y: auto; height: 400px; width:540px;">
	<table border="1" >
        <s:iterator value="#request.userlist" status="stuts" id="iter">
        	<tr>  
        	<td>
        	<form action="RootUpdateuser.action" method="post">
				<td><input type="submit" value="update" style="height:20px;width:60px;float:main;" ></td>
				<td><input name="rootuserid" value=<s:property value="#request.userlist.get(#request.useriter).get(0)"/>></td>	
	            <td><input name="rootusername" value=<s:property value="#request.userlist.get(#request.useriter).get(1)"/>></td>
	            <td><input name="rootuserpassword" value=<s:property value="#request.userlist.get(#request.useriter).get(2)"/>></td>
	        </form>
	        </td>
            </tr>
            <% request.setAttribute("useriter",(int)request.getAttribute("useriter")+1); %>
        </s:iterator>
    </table>
    </div>
    <br>
    <br>
    
	Order
	<div style="overflow-x: auto; overflow-y: auto; height: 400px; width:540px;">
	<table border="1" >
        <s:iterator value="#request.entrylist" status="stuts" id="iter">
        	<tr>  
        	<td>
        	<form action="RootUpdateorder.action" method="post">
				<td><input type="submit" value="update" style="height:20px;width:60px;float:main;" ></td>
				<td><input name="orderid" value=<s:property value="#request.entrylist.get(#request.entryiter).get(0)"/>></td>	
	            <td><input name="rootorderbookid" value=<s:property value="#request.entrylist.get(#request.entryiter).get(1)"/>></td>
	            <td><input name="rootorderuserid" value=<s:property value="#request.entrylist.get(#request.entryiter).get(2)"/>></td>
	        </form>
	        </td>
            </tr>
            <% request.setAttribute("entryiter",(int)request.getAttribute("entryiter")+1); %>
        </s:iterator>
    </table>
    </div>
    
</body>
</html>