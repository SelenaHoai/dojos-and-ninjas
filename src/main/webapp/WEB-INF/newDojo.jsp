<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Dojo</title>
<!-- CSS Link -->
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
	
<!-- <!-- Bootstrap Link -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>

	<div class="container mt-5">
		<div class="container">
			<h2>New Dojo</h2>	
			<form:form action="/dojos/create" method='POST' modelAttribute="dojo">		
			 <div class="mb-2 mt-3">
				<form:label path="name">Name: </form:label>
				<form:input type="text" path="name"/>
				<form:errors path="name" class="text-danger"/>
			</div>
			<button class="btn btn-primary">Create</button>
			</form:form>
		</div>
		<div class="mt-5">
			<h2>Dojo Locations</h2>
			<table>
				<tr>
					<th scope="col"></th>
					<th scope="col"></th>
				</tr>
				<tbody>
					<c:forEach var="dojo" items="${dojos}">
				    <tr class="d-flex justify-content-between mt-3">
					    <td><a href="/dojos/${dojo.id}"><c:out value="${dojo.name}"></c:out></a></td>	  
				        <td><form action="/dojos/${dojo.id}/delete" method="post">
					    <input type="hidden" name="_method" value="delete">
					    <input type="submit" value="Delete">
						</form>
						</td>
					</tr>
				   	</c:forEach>
				</tbody>
	    	</table>
		</div>
	</div>

	


</body>
</html>