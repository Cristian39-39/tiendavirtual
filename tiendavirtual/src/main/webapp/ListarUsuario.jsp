<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tienda Generica</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css" integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="http://cdn.datatables.net/1.10.9/css/jquery.dataTables.min.css" />
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/flick/jquery-ui.css">
    <link rel="stylesheet" href="css/table.css">
</head>
<body>
	<!-- Page content -->
	<table id="tabla" class="table">
		<thead class="table-dark">
			<tr>
			<th>Cedula</th>
			<th>Email</th>
			<th>Nombre</th>
			<th>Contraseña</th>
			<th>Usuario</th>
			<th>Opciones</th>
			</tr>
		</thead>
		<tbody id = "cuerpoTabla">
		</tbody>
	      <tfoot>
            <tr>
                <td colspan="6"> <button class="btn btn-success"> <i class="fas fa-plus-circle"></i> </button></td>
            </tr>
        </tfoot>
	</table>
	<label id = "nombreUsuario"></label>
	<label id = "contraseñaUsuario"></label>
	<label id = "emailUsuario"></label>
	
	 <form class ="form1">
        <h2>Registrar usuario</h2>
        <input type="number" class="inputs" id="input1" name="inputCedula" placeholder="Cedula">
        <input type="email" class="inputs" id="input2" name="inputEmail" placeholder="Email">
        <input type="text" class="inputs" id="input3" name="inputNombre" placeholder="Nombre">
        <input type="password" class="inputs" id="input4" name="inputPassword" placeholder="Contraseña">
        <input type="text" class="inputs" id="input5" name="inputUsuario" placeholder="Usuario">
        <input type="submit" name="create" id="crearUsuario" class="button" value="REGISTRAR">
    </form>
    
       <form class ="form2">
        <h2>Actualizar usuario</h2>
        <input type="number" class="inputs" id="input6" name="inputCedula" placeholder="Cedula">
        <input type="email" class="inputs" id="input7" name="inputEmail" placeholder="Email">
        <input type="text" class="inputs" id="input8" name="inputNombre" placeholder="Nombre">
        <input type="password" class="inputs" id="input9" name="inputPassword" placeholder="Contraseña">
        <input type="text" class="inputs" id="input10" name="inputUsuario" placeholder="Usuario">
        <input type="submit" name="create" id="actualizarUsuario" class="button" value="ACTUALIZAR">
    </form>
    <script src="http://code.jquery.com/jquery-1.10.2.js"></script>
    <script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
    <script src="https://cdn.datatables.net/1.10.9/js/jquery.dataTables.min.js"></script>
    <script src="scripts/table.js"></script>
</body>
</html>