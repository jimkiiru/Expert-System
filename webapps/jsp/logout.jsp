<%@include file="taglib_includes.jsp"%>
<%@page import="java.util.*"%>
<%@page import="java.util.Iterator"%>
<html>
<head>
	 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">	
	 <link rel="stylesheet" type="text/css" href="css/style.css">
	 <title>logout Page</title>
</head>
<body>
	 <%		
		 session.removeAttribute("username");
		 session.removeAttribute("password");
		 session.invalidate();
	 %>
<%
	response.sendRedirect("loginC"); 
%>
</body>
</html>