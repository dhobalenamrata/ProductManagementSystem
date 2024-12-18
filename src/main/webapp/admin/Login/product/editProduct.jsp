<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="servlet.*, bean.*"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Edit Product</title>
	</head>
	<body>
		<h1 align="center">Edit Product</h1>
		<%
			AdminBean ab = (AdminBean)session.getAttribute("bean");
			ProductBean pb = (ProductBean)request.getAttribute("pBean");
			out.println("Page belongs to : <span style='color:red'>"+ab.getUserName()+"</span><br>");		
		%>	
		
		<form action="update" method="post">
			<input type="hidden" name="pCode" value=<%= pb.getId() %>>
			<label for="price">Product price : </label>
			<input type="text" name="price" value=<%= pb.getPrice() %>><br>
			<label for="qty">Product Quantity : </label>
			<input type="text" name="qty" value=<%= pb.getQty() %>><br>
			<input type="submit" value="Update Prduct">
			
				
		
		</form>
	</body>
</html>