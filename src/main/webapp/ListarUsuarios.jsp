<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1"%><!-- copiar obligatoriamente si quiero trabajar en visual  linea 1 y 2-->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1"> <!-- copiar obligatoriamente si quiero trabajar en visual y 6 -->
<title>Tienda Generica</title>
<link rel="stylesheet" href="http://cdn.datatables.net/1.10.9/css/jquery.dataTables.min.css" />
<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/flick/jquery-ui.css">
<link rel="stylesheet" href="css/table.css">
</head>
<body>
	<!-- contenido de la pagina -->
	<table id="tabla">
		<thead>
			<tr>
				<th>Cedula</th>
				<th>Email</th>
				<th>Nombre</th>
				<th>Contraseña</th>
				<th>Usuario</th>
			</tr>
		</thead>
		<tbody>
		<tbody id="cuerpoTabla">
		<!-- el cuerpo de la tabla lo vamos a alimentar a traves de un javascript -->
		</tbody>
		</tbody>
	</table>
	<!-- contenido tabla -->
	<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
	<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
	<script src="https://cdn.datatables.net/1.10.9/js/jquery.dataTables.min.js"></script>
	<script src="scripts/table.js"></script>
</body>
</html>