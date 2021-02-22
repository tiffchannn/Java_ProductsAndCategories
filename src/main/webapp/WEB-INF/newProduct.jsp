<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>New Product</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<h1>New Product</h1>
	<a href="/">Dashboard</a>
	
	<div class="newProduct-div">
		<form:form action="/products/new" method="post" modelAttribute="product">
		    <p>
		    	<form:label path="name">Name:</form:label>
		    	<form:errors path="name"></form:errors>
		        <form:input path="name"/>
		    </p>
		    <p>
		        <form:label path="description">Description:</form:label>
		        <form:errors path="description"/>
		        <form:input path="description"/>
		    </p>
		    <p>
		        <form:label path="price">Price:</form:label>
		        <form:errors path="price"/>
		        <form:input path="price"/>
		    </p>
		    <input type="submit" value="Create Product"/>
		</form:form>
	</div>

</body>
</html>