
<%@page import="com.example.shoes.User"%>
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
<h1>Total Registered Users</h1>
<br/>
<br/>
<%List<User> list=(List<User>)session.getAttribute("list"); %>
<table border="3">
<tr><th>Username</th><th>Firstname</th><th>Lastname</th></tr>
<%for(User us:list){%>
<tr><td><%=us.getEmail()%></td><td><%=us.getFirstname()%></td><td><%=us.getLastname()%></td></tr>
<%}%>
</table>
<br/>
<br/>
<form action="search.jsp">
<input type="submit" value="Search User">
</form>
<br/>
<br/>
<form action="login.jsp">
<input type="submit" value="Go to dashboard">
</form>
<br/>
<br/>
<form action="logout.jsp">
<input type="submit" value="Logout">
</form>
</body>
</html>