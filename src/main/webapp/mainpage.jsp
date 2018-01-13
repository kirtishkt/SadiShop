<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Main Page</title>
</head>
<body>
<%@ include file="header.html" %>

<img alt="image" src="store.jpg" style="width: 100%">
<div>

<h1>Features</h1>
<table class=".table-bordered" style="flaot:left">
<tr>
<th><a href="addstock.jsp">Add Stock</a></th>
<th style="color:white">aaaaaaaaaaaa</th>
<th><a href="order.jsp">Place Order</a></th>
</tr>

<tr>
<th><a href="addcustomer.jsp">Add Customer</a></th>
<th style="color:white">aaaaaaaaaaaa</th>
<th><a href="updateStock.jsp">Update Stock</a></th>
</tr>

<tr>
<th><a href="bill.jsp">Get Bill</a></th>
</tr>
</table>

<h1>Services</h1>
<table class=".table-bordered" style="flaot:right">
<tr>
<th><a href="getStock.jsp">Get Stock</a></th>
<th style="color:white">aaaaaaaaaaaa</th>
<th><a href="control/allStock">All Stock</a></th>
</tr>
<tr>
<th><a href="getorder.jsp">Get Order</a></th>
<th style="color:white">aaaaaaaaaaaa</th>
<th><a href="addcustomerself.jsp">Add Customer</a></th>
</tr>

</table>

</div>


</body>
</html>