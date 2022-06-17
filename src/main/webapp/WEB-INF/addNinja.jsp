<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- CSS Link -->
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
	
<!-- <!-- Bootstrap Link -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>

	<div class="container mt-5">
		<h2>New Ninja</h2>	
		<form:form action="/ninjas/create" method='POST' modelAttribute="ninja">		
		 <div class="mb-2 mt-3">
			<form:label path="dojo">Dojo:</form:label>
			<form:select path="dojo">
				<c:forEach var="dojo" items="${dojos}">
					<form:option value="${dojo.id}">
						<c:out value="${dojo.name}"/>
					</form:option>
				</c:forEach>
			</form:select>
			<form:errors path="dojo" class="text-danger"/>
		</div>
		 <div class="mb-2 mt-3">
			<form:label path="firstName">First Name: </form:label>
			<form:input type="text" path="firstName"/>
			<form:errors path="firstName" class="text-danger"/>
		</div>
		 <div class="mb-2 mt-3">
			<form:label path="lastName">Last Name: </form:label>
			<form:input type="text" path="lastName"/>
			<form:errors path="lastName" class="text-danger"/>
		</div>
		 <div class="mb-2 mt-3">
			<form:label path="age">Age: </form:label>
			<form:input type="number" path="age"/>
			<form:errors path="age" class="text-danger"/>
		</div>
		<button class="btn btn-primary">Create</button>
		</form:form>
	</div>

</body>
</html>