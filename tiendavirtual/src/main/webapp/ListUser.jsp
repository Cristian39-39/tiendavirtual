<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de usuarios</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css" integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="http://cdn.datatables.net/1.10.9/css/jquery.dataTables.min.css"/>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/flick/jquery-ui.css"/>
<link rel="stylesheet" href="css/table.css" />

</head>
<body>
	<!-- Contenido de la pagina -->
	<table id="myTabla" class="table">
		<thead>
			<tr class="table-dark">
				<th>Cedula</th>
				<th>Email</th>
				<th>Nombre</th>
				<th>Contraseña</th>
				<th>Usuario</th>
				<th>Opciones</th>			
			<tr/>
		</thead>
		<tbody id="cuerpoTabla"></tbody>
	</table>
	<label id="nombreUsuario"></label>
	<label id="contraseñaUsuario"></label>
	<label id="emailUsuario"></label>
	<!-- Scripts -->
	<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
	<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
	<script src="http://cdn.datatables.net/1.10.9/js/jquery.dataTables.min.js"></script>
	<script src="scripts/table.js"></script>
	
</body>
</html>