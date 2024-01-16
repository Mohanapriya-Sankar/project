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
label{color:#EF4355;font-weight: bold;font-size:large;}
input  {background-color: #FAC3C9;border-color:#EF4355 ; padding: 10px 16px;}
</style>
<meta charset="ISO-8859-1">
<title> Admin Page</title>
</head>
<body style="background-image:url(admin1.jpg);background-repeat: no-repeat; background-size: cover;">
<center>
	<form action="./AdminChoiceConroller">
		<tr><input type="submit" name="admin" value="Add Product" ></tr>
		<br><br>
		<tr><input type="submit" name="admin" value="View Product" ></tr>
		<br><br>
		<tr><input type="submit" name="admin" value="User Control"></tr>
	</form>
</center>
</body>
</html>