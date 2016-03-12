<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	request.getAttribute("carlist");
	request.getAttribute("booklist");
	session.getAttribute("trolley");
%>

<html>
<head>
<title>main</title>
</head>
<body>
	Hello World, <s:property value="username"/>,<s:property value="password"/>
	<form action="UserProfile.action" method="get">
		<input type="submit" value="Profile" style="height:20px;width:60px;float:main;" >
	</form>
	
	<form action="LogOut.action" method="get">
		<input type="submit" value="Logout" style="height:20px;width:60px;float:main;" >
	</form>
	
	<div style="overflow-x: auto; overflow-y: auto; height: 250px; width:500px;">
		<table border="1" >
        <s:iterator value="#request.booklist" status="stuts">
        	<tr>                
                <s:iterator value="#request.booklist.get(#stuts.index)" status="attrindex">
	                <s:if test="#attrindex.index==0">
	                <td>
			            <form action="UserAddbook.action" method="post">
							<input type="hidden" name="addbookid" value=<s:property/>>
							<input type="hidden" name="username" value=<s:property value="username"/>>
								
							<input type="submit" value="add" style="height:20px;width:60px;float:main;" >
						</form>	
					</td>
					</s:if>
	            	<td valign="middle" align="center">
	            		<s:property />
	            	</td>
	            </s:iterator>
            </tr>
        </s:iterator>
    </table>
	</div>
	
	Trolley
	<div style="overflow-x: auto; overflow-y: auto; height: 400px; width:540px;">
	<table border="1" >
        <s:iterator value="#session.trolley" status="bookindex">
        	<tr>
                <s:iterator value="#session.trolley.get(#bookindex.index)" status="attrindex">
					<s:if test="#attrindex.index==0">
					<td valign="middle" align="center">
						<form action="UserRemovebook.action" method="post">
							<input type="hidden" name="removebookid" value=<s:property/>>
							<input type="hidden" name="username" value=<s:property value="username"/>>
								
							<input type="submit" value=remove style="height:20px;width:60px;float:main;">
						</form>
					</td>
					<td valign="middle" align="center">
						<form action="UserOrderbook.action" method="post">
							<input type="hidden" name="orderbookid" value=<s:property/>>
							<input type="hidden" name="username" value=<s:property value="username"/>>
							
							<input type="submit" value=order style="height:20px;width:60px;float:main;">	
						</form>
					</td>
					</s:if>
	            	<td valign="middle" align="center">	
	            		<s:property />
	            	</td>
	            </s:iterator>
            </tr>
        </s:iterator>
    </table>
    </div>
    
	My Shopping Cart
	<div style="overflow-x: auto; overflow-y: auto; height: 400px; width:540px;">
	<table border="1" >
        <s:iterator value="#request.carlist" status="bookindex">
        	<tr>
                <s:iterator value="#request.carlist.get(#bookindex.index)" status="attrindex">
					<s:if test="#attrindex.index==0">
					<td>
						<form action="UserRemovebook.action" method="post">
							<input type="hidden" name="removebookid" value=<s:property/>>
							<input type="hidden" name="username" value=<s:property value="username"/>>
								
							<!-- <input type="submit" value=remove?? style="height:20px;width:60px;float:main;"> -->
						</form>
					</td>
					</s:if>
	            	<td valign="middle" align="center">
	            		<s:property />
	            	</td>
	            </s:iterator>
            </tr>
        </s:iterator>
    </table>
    </div>
    
</body>
</html>