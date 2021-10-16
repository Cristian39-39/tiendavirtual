/**
 * 
 */
var saveme =  $.ajax({
        type: "GET",
        url: "http://localhost:8080/Usuarios/Lista", //ruta de la API consultaremos.
      
        success: function(data) {
        	console.log(data)
          $.each(data, function(i, item) {
	          lista = document.getElementById("cuerpoTabla");
	          var tr = document.createElement("tr");
			  var idtr = document.createAttribute("id")
			  idtr.value=item.cedulaUsuario;
			  tr.setAttributeNode(idtr);
	
	          var columna1 = document.createElement("th");
	          columna1.innerHTML = item.cedulaUsuario;
	          var columna2 = document.createElement("th");
	          columna2.innerHTML = item.emailUsuario;
	          var columna3 = document.createElement("th");
	          columna3.innerHTML = item.nombreUsuario;
	          var columna4 = document.createElement("th");
	          columna4.innerHTML = item.password;
	          var columna5 = document.createElement("th");
	          columna5.innerHTML = item.usuario;

			  var columna6 = document.createElement("th");
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
   
	          lista.appendChild(tr);
	          tr.appendChild(columna1);
	          tr.appendChild(columna2);
	          tr.appendChild(columna3);
			  tr.appendChild(columna4);
	          tr.appendChild(columna5);
	          tr.appendChild(columna6);
              columna6.appendChild(button);
			  button.appendChild(icon);
	          columna6.appendChild(button2);
			  button2.appendChild(icon2);

             
	       
         });
      }
 });

$('table').on('click','.btnConsultar', function(){
	var cedula = $(this).attr('id')
	$.ajax({
		type: "GET",
		url: "http://localhost:8080/Usuarios/"+cedula,
		dataType: "json",
		error: function (){
			alert("Error en la petición");
			
		}
		
		
	}).done(function(data){
		var infonombre = document.getElementById('nombreUsuario')
		infonombre.innerHTML = data.nombreUsuario;
		var infocontrasena= document.getElementById('contraseñaUsuario')
		infocontrasena.innerHTML = data.password;
	})	
})

//DELETE= eliminar DELETE
$('table').on('click', '.btnEliminar',function(){
    var cedula=$(this).attr('id');
    $.ajax({
        type:"DELETE",
        url:"http://localhost:8080/Usuarios/"+cedula
    }).done(function(){
        location.reload();
    })
})
//PUT= actualizar UPDATE
$('#actualizarUsuario').click(function(event){
    var cedula = $("#input6}").val();
    var email = $("#input7").val();
    var nombre = $("#input8").val();
    var clave = $("#input9").val();
    var usuario = $("#input10").val();
    
    //JSON
    var user={
        cedulaUsuario:cedula,
        emailUsuario: email,
          nombreUsuario: nombre,
          password: clave,
          usuario: usuario
    }
    $.ajax({
        type:"POST",
        data:JSON.stringify(user), //esto permite convertir el string de user a objeto JSON
        url:"http://localhost:8080/Usuarios/",
        contentType:"application/json"
    })
    
})

     





//POST= crear INSERT
$('#crearUsuario').click(function(event){
    var cedula = $("#input1").val();
    var email = $("#input2").val();
    var nombre = $("#input3").val();
    var clave = $("#input4").val();
    var usuario = $("#input5").val();
    
    //JSON
    var user={
        cedulaUsuario:cedula,
        emailUsuario: email,
          nombreUsuario: nombre,
          password: clave,
          usuario: usuario
    }
    $.ajax({
        type:"POST",
        data:JSON.stringify(user), //esto permite convertir el string de user a objeto JSON
        url:"http://localhost:8080/Usuarios/",
        contentType:"application/json"
    })
    
})

     