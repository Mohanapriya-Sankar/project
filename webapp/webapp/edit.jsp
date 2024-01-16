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
<title>Admin Page</title>
</head>
<body style="background-image:url(admin1.jpg);background-repeat: no-repeat; background-size: cover;">
<form action="editcontrol" method="get">
<center>
<table>
<tr>
		<td><label>Product ID</label></td>
		<td><%session.setAttribute("id",Integer.parseInt(request.getParameter("Id")));
		out.println(request.getParameter("Id"));%></td>
	</tr>
	<tr>
		<td><label>Product Name</label></td>
		<td><% out.println(request.getParameter("name"));%></td>
	</tr>
	<tr>
		<td><label>Product Description</label></td>
		<td><% out.println(request.getParameter("desc"));%></td>
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
</center>
<br><br>
<center><input type="submit" value="Update"></center>
</form>
</body>
</html>