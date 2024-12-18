<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="bean.*"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Product updated</title>
	</head>
	<body>
		<h2>
			<%
				AdminBean ab = (AdminBean)session.getAttribute("bean");
				String msg = (String)request.getAttribute("msg");
				out.println("Page belongs to : "+ab.getUserName()+"<br>");
				
			%>
		</h2>
		<h5>
			<%
				out.println(msg);
			%>		
		</h5>
		
		<a href="admin/Login/product/index.html">Add Product</a>
		<a href="view">Show all Products</a>
		<a href="logout">Logout</a>
		
		
		
		
		
	</body>
</html>