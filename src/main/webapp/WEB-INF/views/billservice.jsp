<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bill</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
</head>
<body>
<%@ include file="header.html" %>
<div class="container">
<div class="table-responsive">

<table class="table">
<tr>
<th>Design No</th>
<th>Quantity</th>
<th> Price</th>
<th>Total Price</th>
</tr>
<c:set var="sum" value="${0 }"></c:set>
<c:forEach items="${stock }" var="s" varStatus="status">
<tr>
<td>${s.designNo }</td>
<td>${items[s.designNo].quantity }</td>
<td>${s.price}</td>
<td>${s.price * items[s.designNo].quantity}</td>
<c:set var="sum" value="${ sum + s.price * items[s.designNo].quantity}"></c:set>
</tr>
</c:forEach>
</table>
</div>
</div>
<h3 align="center">Total Amount: ${sum }</h3>
</body>
</html>