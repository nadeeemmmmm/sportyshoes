<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<br/>
<br/>
<div align="right">
<form action="logout">
<input type="submit" value="Logout">
</form>
</div>
<%String user=(String)session.getAttribute("user"); %>
<br/>
<%=user %>
<br/>
<h1>Welcome to Sporty Shoes</h1>
<br/>
<br/>
<form action="login.jsp">
<input type="submit" value="Running Shoes" style="float: left;"><br/>
</form>
<form action="login.jsp">
<input type="submit" value="Walking Shoes" style="float: left;"><br/>
</form>
<form action="login.jsp">
<input type="submit" value="Gym Shoes" style="float: left;"><br/>
</form>
<form action="login.jsp">
<input type="submit" value="Stylish Shoes" style="float: left;"><br/>
</form>
<br/>
<br/>
<form action="category">
Choose the Category: <select name="type">
             <option value="Running Shoes">Running Shoes</option>
             <option value="Walking Shoes">Walking Shoes</option>
             <option value="Gym Shoes">Gym Shoes</option>
             <option value="Stylish shoes">Stylish Shoes</option>
          </select>
          <br/>
          <br/>
<input type="submit" value="Search">          
</form>
</body>
</html>