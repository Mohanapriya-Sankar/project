<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style> 
input[type=submit], input[type=reset] {
  background-color:#383838;
  border: none;
  color: white;
  padding: 10px 16px;
  text-decoration:none;
  margin: 4px 2px;
  cursor: pointer;
}
label{color:#383838;font-weight: bold;font-size:large;}
input  {background-color:#FFFFCC;border-color:#383838 ; padding: 10px 16px;}
</style>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body style="background-image:url(admin1.jpg);background-repeat: no-repeat; background-size: cover;">
<center>
	<form action="./RegisterationController" method="get">
	<h1>Registeration Details</h1>
	<table>
	<tr>
		<td><label>Product ID</label></td>
		<td><input type="text" name="Id" placeholder="Enter the ID"></td>
	</tr>
	<tr>
		<td><label>Product Name</label></td>
		<td><input type="text" name="Name" placeholder="Enter the Product Name"></td>
	</tr>
	<tr>
		<td><label>Product Description</label></td>
		<td><input type="text" name="Description" placeholder="Enter the Description"></td>
	</tr>
	<tr>
		<td><label>Available Quantity</label></td>
		<td><input type="text" name="Quantity" placeholder="Enter the Quantity"></td>
	</tr>
	<tr>
		<td><label>Price</label></td>
		<td><input type="text" name="Price" placeholder="Enter the price of the product"></td>
	</tr>
	</table>
	<br><br>
	<input type="submit">
	</form>
</center>
</body>
</html>