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
			<th>Nit</th>
			<th>ciudad</th>
			<th>Dirección</th>
			<th>Proveedor</th>
			<th>Telefono</th>
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
	
	 <form class ="form1" name="form1" id="form1">
        <h2>Registrar proveedor</h2>
        <input type="number" class="inputs" id="input1" name="inputNit" placeholder="Nit proveedor...">
        <input type="text" class="inputs" id="input2" name="inputCiudad" placeholder="Ciudad...">
        <input type="text" class="inputs" id="input3" name="inputDireccion" placeholder="Dirección...">
        <input type="text" class="inputs" id="input4" name="inputProveedor" placeholder="Proveedor...">
        <input type="text" class="inputs" id="input5" name="inputTelefono" placeholder="Teléfono...">
        <input type="submit" name="create" id="crearUsuario" class="button" value="REGISTRAR">
    </form>
    
       <form class ="form2" name="form2" id="form2">
        <h2>Actualizar proveedor</h2>
        <input type="number" class="inputs" id="input6" name="input6" placeholder="Nit proveedor...">
        <input type="text" class="inputs" id="input7" name="input7" placeholder="Ciudad...">
        <input type="text" class="inputs" id="input8" name="input8" placeholder="Dirección...">
        <input type="text" class="inputs" id="input9" name="input9" placeholder="Proveedor...">
        <input type="text" class="inputs" id="input10" name="input10" placeholder="Teléfono...">
        <input type="submit" name="create" id="actualizarUsuario" class="button" value="ACTUALIZAR">
    </form>
    <script src="http://code.jquery.com/jquery-1.10.2.js"></script>
    <script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
    <script src="https://cdn.datatables.net/1.10.9/js/jquery.dataTables.min.js"></script>
    <script src="scripts/tableProveedores.js"></script>
</body>
</html>