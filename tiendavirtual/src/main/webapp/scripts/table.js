/**
 * Alñimentar tabla de usuarios
 */

saveme()
function saveme (){
/*	var n = document.getElementById("cuerpoTabla");

	function clearInner(node) {
	  while (node.hasChildNodes()) {
	    clear(node.firstChild);
	  }
	}
	
	function clear(node) {
	  while (node.hasChildNodes()) {
	    clear(node.firstChild);
	  }
	  node.parentNode.removeChild(node);
	  console.log(node, "cleared!");
	}
	
	clearInner(n);*/
	
	$.ajax({
	type: "POST",
	url: "http://localhost:8080/Usuarios/listarUsuarios",
	
	success: function(data){
		let lista = document.getElementById("cuerpoTabla");
		lista.innerHTML = '';
		$.each(data, function(i, item){
			var tr = document.createElement("tr");
			var idTr = document.createAttribute("id");
			var classTr = document.createAttribute('class')
			classTr.value = "classData";
			idTr.value = item.cedulaUsuario;
			tr.setAttributeNode(idTr);
			tr.setAttributeNode(classTr);
			
			var columna1 = document.createElement("td");
			columna1.innerHTML = item.cedulaUsuario;
			var columna2 = document.createElement("td");
			columna2.innerHTML = item.emailUsuario;
			var columna3 = document.createElement("td");
			columna3.innerHTML = item.nombreUsuario;
			var columna4 = document.createElement("td");
			columna4.innerHTML = item.password;
			var columna5 = document.createElement("td");
			columna5.innerHTML = item.usuario;
			var columna6 = document.createElement("td");
			//
			var button = document.createElement("button");
			var idButton = document.createAttribute("id");
			idButton.value = item.cedulaUsuario;
			button.setAttributeNode(idButton);
			
			var classButton = document.createAttribute("class");
			classButton.value = "btn btn-info btnConsultar";
			button.setAttributeNode(classButton);
			
			var icon = document.createElement("i");
			var classIcon = document.createAttribute("class");
			classIcon.value = "fa fa-search";
			icon.setAttributeNode(classIcon);
			//
			var button2 = document.createElement("button");
			var idButton2 = document.createAttribute("id");
			idButton2.value = item.cedulaUsuario;
			button2.setAttributeNode(idButton2);
			
			var classButton2 = document.createAttribute("class");
			classButton2.value = "btn btn-danger btnEliminar";
			button2.setAttributeNode(classButton2);
			
			var icon2 = document.createElement("i");
			var classIcon2 = document.createAttribute("class");
			classIcon2.value = "fa fa-duotone fa-user-large-slash";
			icon2.setAttributeNode(classIcon2);
			//
			var button3 = document.createElement("button");
			var idButton3 = document.createAttribute("id");
			idButton3.value = item.cedulaUsuario;
			button3.setAttributeNode(idButton3);
			
			var classButton3 = document.createAttribute("class");
			classButton3.value = "btn btn-success btnCrear";
			button3.setAttributeNode(classButton3);
			
			var icon3 = document.createElement("i");
			var classIcon3 = document.createAttribute("class");
			classIcon3.value = "fa fa-duotone fa-user-plus";
			icon3.setAttributeNode(classIcon3);
			//
			var button4 = document.createElement("button");
			var idButton4 = document.createAttribute("id");
			idButton4.value = item.cedulaUsuario;
			button4.setAttributeNode(idButton4);
			
			var classButton4 = document.createAttribute("class");
			classButton4.value = "btn btn-warning btnActualizar";
			button4.setAttributeNode(classButton4);
			
			var icon4 = document.createElement("i");
			var classIcon4 = document.createAttribute("class");
			classIcon4.value = "fa fa-duotone fa-user-pen";
			icon4.setAttributeNode(classIcon4);
			//
			
			
			lista.appendChild(tr);
			tr.appendChild(columna1);
			tr.appendChild(columna2);
			tr.appendChild(columna3);
			tr.appendChild(columna4);
			tr.appendChild(columna5);
			tr.appendChild(columna6);
			columna6.appendChild(button)
			button.appendChild(icon)
			columna6.appendChild(button2)
			button2.appendChild(icon2)
			columna6.appendChild(button3)
			button3.appendChild(icon3)
			columna6.appendChild(button4)
			button4.appendChild(icon4)
			
			//
		});
	}
})};
saveme()
$('table').on('click', '.btnConsultar', function(){
	var cedula = $(this).attr('id');
	$.ajax({
		type: "GET",
		url: "http://localhost:8080/Usuarios/"+cedula,
		dataType:"json",
		error:function(){
			alert("error en la petición")
		}
	}).done(function(data){
		var infoNombre = document.getElementById('nombreUsuario')
		infoNombre.innerHTML = data.nombreUsuario
		var infoContraseña = document.getElementById('contraseñaUsuario')
		infoContraseña.innerHTML = data.password
		var infoEmail = document.getElementById('emailUsuario')
		infoEmail.innerHTML = data.emailUsuario
	})
})

$('table').on('click', '.btnEliminar', function(){
	var cedula=$(this).attr('id');
	$.ajax({
		type:"DELETE",
		url: "http://localhost:8080/Usuarios/"+cedula,
		contentType: "application/json",
	})
	saveme()
})





