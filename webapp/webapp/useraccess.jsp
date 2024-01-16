<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Access</title>
<style>
th, td {
border-style:groove;
}
</style>
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
</head>
<body style="background-image:url(admin1.jpg);background-repeat: no-repeat; background-size: cover;">
<table>
<tr>
<th>Name</th>
<th>Email</th>
<th>Password</th>
<th>Authorization</th>
<th>Deauthorization</th>
<th>Remove</th>
</tr>
<c:forEach var="pro" items="${Ulist}">
<tr>
<td><c:out value="${pro.name }"></c:out></td>
<td><c:out value="${pro.email}"></c:out></td>
<td><c:out value="${pro.password}"></c:out></td>
<td><a href="Authorise?name=${pro.name}">Authorize</a></td>
<td><a href="Deauthorise?name=${pro.name}">Deauthorize</a></td>
<td><a href="DeleteUser?name=${pro.name}">Delete</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>