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
<h1>Search Result</h1>
<br/>
<br/>
<form action="login.jsp">
<input type="submit" value="Go Back">
</form>
<br/>
<br/>
<%List<Products> list=(List<Products>)session.getAttribute("list"); %>
<table border="3">
<tr><th>Id</th><th>Name</th><th>Price</th></tr>
<%for(Products pr:list){%>
<tr><td><%=pr.getId() %></td><td><%=pr.getName() %></td><td><%=pr.getPrice() %></td></tr>
<%} %>
</table>
<br/>
<br/>
<h2>To Place order, Please Confirm Product Id</h2>
<form action="cart">
Id: <input type="text" name="id">
<input type="submit" value="Add">
</form>
</div>
</body>
</html>