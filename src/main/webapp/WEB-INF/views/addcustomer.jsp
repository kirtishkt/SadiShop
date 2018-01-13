<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Customer</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<link rel="stylesheet" type="text/css"
	href="<c:url value="resources/getdetails.css"></c:url>">
	
</head>
<body>
	<%@ include file="header.html"%>
	<div class="form-style-10">
		<h1>Enter Customer Details</h1>
		<form action="addCustomer" method="post">
			
			<div class="inner-wrap">
				
				<label>Customer Name: <input type="text" name="name" style="width:50%" required></input></label>
				<label>Address <input type="text" name="address" style="width:50%" required></input></label>
			</div>
			<div class="button-section">
				<input type="submit" name="Sign Up" />
			</div>
		</form>
	</div>
</body>
</html>