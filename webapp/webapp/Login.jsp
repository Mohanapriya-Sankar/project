<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style> 
input[type=submit], input[type=reset] {
  background-color:#EF4355;
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
<p style="color:red;text-aline:center">${msg}</p>
<title>Login Page</title>
</head>
<body style="background-image:url(updated.jpg);background-repeat: no-repeat; background-size: cover;">
<form action="./LoginController">
<center>
<table>
<tr>
<td><label>Name</label></td>
<td><input type="text" name="id" placeholder="Enter the registered mail id"></td>
</tr>
<tr>
<td><label>Password</label></td>
<td><input type="text" name="pass" placeholder="Enter the Password"></td>
</tr>
</table>
<input type="submit">
</center>
</form>
</body>
</html>