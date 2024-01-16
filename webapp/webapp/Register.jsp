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
<title>Insert title here</title>
</head>
<body style="background-image:url(updated.jpg);background-repeat: no-repeat; background-size: cover;">
<form action="./RegisterUserControl">
<center>
<table>
<tr>
<td><label>Name</label></td>
<td><input type="text" name="name" placeholder="Enter your name"></td>
</tr>

<tr>
<td><label>Date of Birth</label></td>
<td><input type="date" name="dob" placeholder="Date of Birth"></td>
</tr>

<tr>
<td><label>Mobile Number</label></td>
<td><input type="text" name="num" placeholder="Enter your Mobile Number"></td>
</tr>

<tr>
<td><label>Email</label></td>
<td><input type="text" name="email" placeholder="Enter your Mail-Id"></td>
</tr>

<tr>
<td><label>Password</label></td>
<td><input type="password" name="pass" placeholder="Enter a Valid Password"></td>
</tr>

</table>

<tr><input type="submit" value="Register"></tr>
<br><br>
<tr><input type="reset"></tr>
</center>

</form>
</body>
</html>