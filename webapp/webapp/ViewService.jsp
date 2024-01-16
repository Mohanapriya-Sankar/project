<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Of Products</title>
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

<form action="admin?Id=${pro.Id}">

<h1>Product List</h1>

<table>
<tr>
<th>Product Id</th>
<th>Product Name</th>
<th>Product Description</th>
<th>Product Price</th>
<th>Product Quantity</th>
<th>Remove</th>
<th>Edit Product</th>
</tr>
<c:forEach var="pro" items="${pList}">
<tr>
<td><c:out value="${pro.id }"></c:out></td>
<td><c:out value="${pro.name }"></c:out></td>
<td><c:out value="${pro.description }"></c:out></td>
<td><c:out value="${pro.price }"></c:out></td>
<td><c:out value="${pro.quantity }"></c:out></td>
<td><a href="deleteControl?id=${pro.id}">Delete</a></td>
<td><a href="edit.jsp?Id=${pro.id}&name=${pro.name}&desc=${pro.description }">Edit</a></td>
</tr>
</c:forEach>
</table>
</form>
</body>
</html>