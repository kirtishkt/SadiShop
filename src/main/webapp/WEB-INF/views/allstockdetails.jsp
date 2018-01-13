<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Stock Details</title>
</head>
<body>
<%@ include file="header.html" %>
<div class="container">
<div class="table-responsive">

<table class="table">
<tr>
<th>Design No</th>
<th>Quantity</th>
<th>Price</th>
</tr>
<c:forEach items="${stock }" var="s">
<tr>
<td>${s.designNo }</td>
<td>${s.quantity }</td>
<td>${s.price }</td>
</tr>
</c:forEach>
</table>
</div>
</div>

</body>
</html>