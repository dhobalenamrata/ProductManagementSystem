<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="bean.*"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Message.jsp</title>
	</head>
	<body>
		<%
			String ab = (String)session.getAttribute("msg");
			out.println(ab+"<br>");
			
		%>
	</body>
</html>