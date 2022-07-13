<%@page import="java.util.List"%>
<%@page import="com.example.shoes.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Order Placed Successfully</h1>
<br/>
<br/>
<%List<Ship> sh=(List<Ship>)request.getAttribute("list2"); %>
<table border="3">
<tr><th>Address</th><th>Contact</th><th>ZipCode</th></tr>
<%for(Ship ship:sh){%>
<tr><td><%=ship.getAddress()%></td><td><%=ship.getContact() %></td><td><%=ship.getZipcode()%></td></tr>
<%}%>
</table>
<br/>
<br/>
<%List<Orders> order=(List<Orders>)request.getAttribute("list1"); %>
<table border="3">
<tr><th>Product Id</th><th>Product Name</th><th>Price</th></tr>
<%for(Orders ord:order){%>
<tr><td><%=ord.getProductid() %></td><td><%=ord.getName() %></td><td><%=ord.getPrice()%></td></tr>
<%}%>
</table>
</body>
</html>