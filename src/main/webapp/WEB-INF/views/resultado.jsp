<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Bus Stop Web App</title>
		<link href="css/bootstrap.css" rel="stylesheet" media="screen">
		<script src="js/bootstrap.js"></script>
	</head>
	<body>
		<h2>Bus Stop Web App</h2>
		<h3>List of buses</h3>
		<c:if test="${not empty busesList}">
			<ul>
				<c:forEach var="bus" items="${busesList}">
					<li>
						<p>${bus.id}</p>
						<p>${bus.name}</p>
						<p>${bus.lineNumber}</p>
					</li>
				</c:forEach>
			</ul>
		</c:if>
		<c:if test="${empty busesList}">
			<h4>No hay buses</h4>
		</c:if>
	</body>
</html>