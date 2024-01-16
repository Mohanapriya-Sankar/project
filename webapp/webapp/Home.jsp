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
<title>Home Page</title>
</head>
<body style="background-image:url(updated.jpg);background-repeat: no-repeat; background-size: cover;">
<form action="./HomepageControl">
<center>
		<tr>
			<td><input type="submit" name="index" value="Home"></td>
			<td><input type="submit" name="index" value="Register"></td>
			<td><input type="submit" name="index" value="Login"></td>
		</tr>
</center>
</form>
</body>
</html>