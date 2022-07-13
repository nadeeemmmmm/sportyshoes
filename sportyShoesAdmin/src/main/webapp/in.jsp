<%@page import="com.example.shoes.Category"%>
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
<br/>
<h1>All Categories</h1>
<br/>
<br/>
<form action="out.jsp">
<input type="submit" value="Add New Category">
</form>
<br/>
<br/>
<form action="login.jsp">
<input type="submit" value="Go Back">
</form>
<br/>
<br/>
<%List<Category> list=(List<Category>)request.getAttribute("list"); %>
<table border="3">
<tr><th>Id</th><th>Name</th><th>Action</th></tr>
<%for(Category ct:list){%>
<tr><td><%=ct.getId()%></td><td><%=ct.getName()%></td><td><a href="edit.jsp">Edit</a></td><td><a href="delete.jsp">Delete</a></td></tr>
<%}%>
</table>
</div>
</body>
</html>