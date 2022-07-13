
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Result</h1>
<br/>
<br/>
<%Object list=session.getAttribute("list"); %>
<%=list%>
<br/>
<br/>
<form action="login.jsp">
<input type="submit" value="Go back">
</form>
</body>
</html>