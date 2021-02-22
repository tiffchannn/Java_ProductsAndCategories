<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<h1>New Category</h1>
	<a href="/">Dashboard</a>
	
	<div class="newCategory-div">
		<form:form action="/categories/new" method="post" modelAttribute="category">
		    <p>
		    	<form:label path="name">Name:</form:label>
		    	<form:errors path="name"></form:errors>
		        <form:input path="name"/>
		    </p>
		    <input type="submit" value="Create Category"/>
		</form:form>
	</div>
</body>
</html>