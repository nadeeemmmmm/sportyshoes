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
<h1>Hello, Please login</h1>
<br/>
<form action="login" method="post">
UserName: <input type="email" name="email"><br>
<br/>
Password: <input type="password" name="pwd"><br>
<br/>
<br/>
<input type="submit" value="Login">
</form>
<br/>
<br/>
<a href="register.jsp">New User? Register here</a>
<br/>
<br/>
<a href="password.jsp">Forgot Password?</a>
</div>
</body>
</html>