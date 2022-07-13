<%@page import="com.example.shoes.Products"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>All Products</h1>
<br/>
<br/>
<form action="login.jsp">
<input type="submit" value="Go Back">
</form>
<br/>
<br/>
<form action="add.jsp">
<input type="submit" value="Add Product">
</form>
<br/>
<br/>
<%List<Products> list=(List<Products>)request.getAttribute("list"); %>
<table border="3">
<tr><th>Product Id</th><th>Product Name</th><th>Category</th><th>Price</th><th>Action</th></tr>
<%for(Products pp:list){%>
<tr><td><%=pp.getId() %></td><td><%=pp.getName() %></td><td><%=pp.getCategory() %></td><td><%=pp.getPrice() %></td><td><a href="quant.jsp">Add Quantity</a></td></tr>
<%}%>
</table>
</body>
</html>