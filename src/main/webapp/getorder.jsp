<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bill</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<sql:setDataSource var="database" driver="com.mysql.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/shop?autoReconnect=true&useSSL=false"
	user="root" password="kt" />

<sql:query var="p" dataSource="${database}"
	sql="select order_id from orders"></sql:query>

<link rel="stylesheet" type="text/css"
	href="<c:url value="control/resources/getdetails.css"></c:url>">

</head>
<body>
	<%@ include file="header.html"%>
<div class="form-style-10">
<h1>Enter Stock ID</h1>
	<form action="control/getOrder" method="post">
	<div class="inner-wrap">
				<label>Order ID<input list="orders" name="order_id" type="number" style="width:50%" required/></label>
				<datalist id="orders"> 
				<c:forEach var="x"
					items="${p.rows}">
					<option value='<c:out value="${x.order_id}"/>'></option>
				</c:forEach> </datalist>
			</div>
			<input type="submit" name="Submit">
	</form>
</div>


	

</body>
</html>