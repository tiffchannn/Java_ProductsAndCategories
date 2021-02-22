<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Product Page</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div class="header">
		<p></p>
		<h1  class="header1"><c:out value="${product.name}"/></h1>
		<a href="/">Dashboard</a>
	</div>
	
	<div class="container">
		<div class="categorylist-div">
			<h2>Categories:</h2>
			<ul>
			<!-- list of categories for a PRODUCT -->
				<c:forEach items="${categoryList}" var="category">
					<li><c:out value="${category.name}"/></li>
				</c:forEach>
			</ul>
		</div>
		
		<div class="dropdown-div">
			<form action="/products/${id}" method="post">
				<label for="categoryId">Add A Category:</label>
		    	<select name="categoryId">
		    	<option value="" disabled selected>Select a Category!</option>
		    		<c:forEach items="${categories}" var="c">
						<option value="${c.id}">
							<c:out value="${c.name}"></c:out>
						</option>
					</c:forEach>
		    	</select>
		    	<button type="submit">Add Category to Product!</button>
		    </form>
		</div>
	</div>
	
</body>
</html>