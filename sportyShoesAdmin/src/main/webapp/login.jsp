<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="left">
<%String admin=(String)session.getAttribute("admin"); %>
<h1>Sporty Shoes Admin</h1>
<br/>
<%=admin %>
<br/>
<br/>
<form action="fetch">
<input type="submit" value="Products">
</form>
<br/>
<form action="get">
<input type="submit" value="Categories">
</form>
<br/>
<form action="logout">
<input type="submit" value="Logout">
</form>
</div>
<div align="right">
<form action="check">
<input type="submit" value="Total Users">
</form>
</div>
</body>
</html>