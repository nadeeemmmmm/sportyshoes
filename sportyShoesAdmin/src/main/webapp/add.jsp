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
<h1>Add New Product</h1>
<br/>
<form action="product">
Product Id: <input type="text" name="id">
<br/>
<br/>
Product Name: <input type="text" name="name">
<br/>
<br/>
Category: <select name="cat">
             <option value="Running Shoes">Running Shoes</option>
             <option value="Walking Shoes">Walking Shoes</option>
             <option value="Gym Shoes">Gym Shoes</option>
             <option value="Stylish shoes">Stylish Shoes</option>
          </select>
<br/>
<br/>
Price: <input type="text" name="price">
<br/>
<br/>
<input type="submit" value="Add">
</form>
<br/>
<form action="login.jsp">
<input type="submit" value="Cancel">
</form>
</div>
</body>
</html>