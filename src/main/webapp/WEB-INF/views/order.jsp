<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Place order</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<sql:setDataSource var="database" driver="com.mysql.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/shop?autoReconnect=true&useSSL=false"
	user="root" password="kt" />

<sql:query var="p" dataSource="${database}"
	sql="select designno from stock"></sql:query>
<sql:query var="c" dataSource="${database}" sql="select * from customer"></sql:query>
<link rel="stylesheet" type="text/css"
	href="<c:url value="resources/getdetails.css"></c:url>">

<script type="text/javascript">
	function add(){
		var container = document.getElementById("container");
		container.appendChild(document.createTextNode("Item "));
		
		var input = document.createElement("input");
		input.type = "text";
		input.setAttribute("name", "item");
		input.setAttribute("list", "product");
		input.setAttribute("style", "width:50%");
		container.appendChild(input);
		
		var q = document.createElement("input");
		q.setAttribute("name", "quantity");
		q.setAttribute("style", "width:50%");
		q.type = "number";
		container.appendChild(document.createTextNode("Quantity "));
		container.appendChild(q);

	}
</script>

</head>
<body>

	<datalist id="product"> <c:forEach var="x" items="${p.rows}">
		<option value="${x.designno}">
		</c:forEach> </datalist>

<datalist id="customers"> <c:forEach var="x"
			items="${c.rows}">
			<option value="${x.cust_id}">${x.cust_name}
		</c:forEach> </datalist>

<%@ include file="header.html"%>

	<div class="form-style-10">
		<h1>Add All Items for Bill</h1>

		<form action="addOrder" method="post">
			<div class="section">Enter All Item Details...</div>
			<div class="inner-wrap"  id="container">
				Item: 	  <input type="text" name = "item" list="product" style="width:50%" required>
				Quantity: <input type="number" name ="quantity" style="width:50%" required>
			</div>
			<div class="inner-wrap">
			Customer:<input type="number" name ="customer" list="customers" style="width:50%" required>
		</div>
			<input type="Submit" name="Submit">
		</form>
		<button id ="add" onclick="add()" style="position:absolute;right:10px;">Add Item</button>
	</div>
	
</body>
</html>