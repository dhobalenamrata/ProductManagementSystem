<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="bean.*, java.util.*"%>
<!DOCTYPE html>
	<html>
	<head>
	<meta charset="UTF-8">
	<title>All Products</title>
	</head>
	<body>
		<h1 align="center">All Products</h1>
		<h5>
			<a href="admin/Login/product/index.html">Add Product</a>
			<a href="logout">Logout</a>
		</h5>
		<%
			AdminBean ab = (AdminBean)session.getAttribute("bean");
			ArrayList<ProductBean> al = (ArrayList<ProductBean>)session.getAttribute("pList");
			out.println("Page Belongs to : "+ ab.getUserName()+"<br>");
			Iterator<ProductBean> it = al.iterator();
			while(it.hasNext()){
				ProductBean pb = it.next();
				out.println(pb.getId()+"&nbsp&nbsp"+pb.getName()+"&nbsp&nbsp"
						+pb.getPrice()+"&nbsp&nbsp"+pb.getQty()+"&nbsp&nbsp"+"<a href='edit?pCode="
				+pb.getId()+"'>Edit</a>"+"&nbsp&nbsp<a href='delete?pCode='"+pb.getId()+"'>"+"Delete</a><br>");
			}
		%>
		
		
	</body>
</html>