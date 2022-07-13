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
<div align="center">
<h1>Items in your Cart</h1>
<br/>
<br/>
<h2>To remove items, Please confirm product Id</h2>
<br/>
<br/>
<form action="delete">
<input type="text" name="id">
<br/>
<input type="submit" value="Remove">
</form>
<br/>
<br/>
<%List<Products> list=(List<Products>)session.getAttribute("cart"); %>
<table border="3">
<tr><th>Product Id</th><th>Name</th><th>Price</th></tr>
<%for(Products pr:list){%>
<tr><td><%=pr.getId() %></td><td><%=pr.getName() %></td><td><%=pr.getPrice()%></td></tr>
<%} %>
</table>
<br/>
<%int sum=(int)session.getAttribute("sum"); %>
Total Amount:<%=sum %>
<br/>
<br/>
<form action="login.jsp">
<input type="submit" value="Add More Items">
</form>
<br/>
<br/>
<form action="ship.jsp">
<input type="submit" value="Check Out">
</form>
</div>
</body>
</html>