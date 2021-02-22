<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Category Page</title>
</head>
<body>
	<h1><c:out value="${category.name}"/></h1>
	
	<div class="product-list-div">
		<h2>Products:</h2>
		<ul>
			<c:forEach items="${productList}" var="product">
				<li><c:out value="${product.name}"/></li>
			</c:forEach>
		</ul>
	</div>
	
	<!-- Dropdown menu to add PRODUCT to CATEGORY -->
	<div class="dropdown-div">
		<form action="/categories/${id}" method="post">
			<label for="productId">Add Product:</label>
			<!-- select options are PRODUCTS which is why path is for products? -->
	    	<select name="productId">  
	    	<option value="" disabled selected>Select a Product!</option>
	    		<c:forEach items="${products}" var="p"> <!-- from the products list -->
					<option value="${p.id}"> <!-- specify by product ID -->
						<c:out value="${p.name}"></c:out>  <!-- display the product's name -->
					</option>
				</c:forEach>
	    	</select>
	    	<button type="submit">Add Product to Category!</button>
	    </form>
	</div>

</body>
</html>