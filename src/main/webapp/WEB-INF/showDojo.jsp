<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dojo Page</title>
<!-- CSS Link -->
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
	
<!-- <!-- Bootstrap Link -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container mt-5">
		<h1>${dojo.name} Location Ninjas</h1>
		<table class="table">
			<tr>
				<th scope="col">First Name</th>
				<th scope="col">Last Name</th>
				<th scope="col">Age</th>
			</tr>
			<tbody>
				<c:forEach var="ninja" items="${dojo.ninjas}">
		        <tr>
			        <td><c:out value="${ninja.firstName}"></c:out></td>
			        <td><c:out value="${ninja.lastName}"></c:out></td>
			        <td><c:out value="${ninja.age}"></c:out></td>		  
		        </tr>
		    	</c:forEach>
				
			</tbody>		
		</table>
		<a href="/dojos">Add a Dojo</a>	
		<a href="/ninjas/new">Add a Ninja</a>	
	</div> 

</body>
</html>