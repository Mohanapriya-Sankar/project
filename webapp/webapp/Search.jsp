<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Portal</title>
</head>
<body style="background-image:url(ECom.jpg);background-repeat: no-repeat; background-size: cover;">
<div class="header"><jsp:include page="User.jsp" /></div>
<form action="SearchProductControl1">
<center>
<table>
<tr>
<td><label>Product Name</label></td>
<td><input type="text" name="search"><br></td>
<td><input type="submit" value="Search"></td></tr>
</table>
</center>
</form>
</body>
</html>