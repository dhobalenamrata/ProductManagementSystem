<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="bean.*"%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Logged in</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
		
		<style>
			span{
				color : red;
			}
		</style>
	</head>
	<body>
		<h4 class="container">Welcome : <span><% 
	
				AdminBean ab = (AdminBean)session.getAttribute("bean");
				out.println(ab.getUserName()+"<br>");
				%></span></h4>
			
			
		<div class="grid text-center">
		<!-- /ProductManagementSystem/src/webapp/admin/Login/product/index.html  -->
			
				<div class="g-col-4"><a href="admin/Login/product/index.html">Add Product</a></div>
		  	
		  	<a href="view"><!-- -->
		  		<div class="g-col-4">View All Products</div>
		  	</a>
		  	<a>	
		  		<div class="g-col-4">Logout</div>
		  	</a>
		</div>
				
		
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
	</body>
</html>