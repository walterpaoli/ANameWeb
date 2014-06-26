<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Bus Stop Web App</title>
		<link href="css/bootstrap.css" rel="stylesheet" media="screen">
		<script src="js/bootstrap.js"></script>
	</head>
	<body>
		<h2>Bus Stop Web App</h2>
		<form action="/ANameWeb/request_buses" method="POST">
			<input id="bus_id" type="text" placeholder="Deja en blanco para ver todos...">
			<input type="submit" text="Enviar">
		</form>
	</body>
</html>