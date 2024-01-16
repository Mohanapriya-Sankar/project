<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Details</title>
<style>
th, td {
border-style:groove;
}

</style>

</head>
<body style="background-image:url(ECom.jpg);background-repeat: no-repeat; background-size: cover;">
<div class="header"><jsp:include page="User.jsp" /></div>
<center>
<table>
<tr>
<th>Product Name</th>
<th>Product Description</th>
<th>Price</th>
<th>Cart</th>
<th>WishList</th>
<th>Purchase</th>
<th>Remove from Cart</th>
</tr>
<c:forEach  var="pro" items="${Plist}">
<tr>
<td><c:out value="${pro.name}"></c:out></td>
<td><c:out value="${pro.description}"></c:out></td>
<td><c:out value="${pro.price }"></c:out></td>
<td><a href="CartControl?name=${pro.name}">Add to Cart</a></td>
<td><a href="WishControl?name=${pro.name}">Add to Wish List</a></td>
<td><a href="Buyme?name=${pro.name}">Buy</a></td>
<td><a href="DeleteCart?name=${pro.name }">Delete</a></td>
</tr>
</c:forEach>
</table></center>
</body>
</html>