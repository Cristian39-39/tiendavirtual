var saveme =  $.ajax({
        type: "GET",
        url: "http://localhost:8080/Clientes/Lista", //ruta de la API consultaremos.
      
        success: function(data) {
          $.each(data, function(i, item) {
	          lista = document.getElementById("cuerpoTabla");
	          var tr = document.createElement("tr");
			  var idtr = document.createAttribute("id")
			  idtr.value=item.cedulaCliente;
			  tr.setAttributeNode(idtr);
	
	          var columna1 = document.createElement("th");
	          columna1.innerHTML = item.cedulaCliente;
	          var columna2 = document.createElement("th");
	          columna2.innerHTML = item.nombreCliente;
	          var columna3 = document.createElement("th");
	          columna3.innerHTML = item.direccionCliente;
	          var columna4 = document.createElement("th");
	          columna4.innerHTML = item.telefonoCliente;
	          var columna5 = document.createElement("th");
	          columna5.innerHTML = item.emailCliente;

			  var columna6 = document.createElement("th");
			  //
				var button = document.createElement("button");
				var idButton = document.createAttribute("id");
				idButton.value = item.cedulaCliente;
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
				idButton2.value = item.cedulaCliente;
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
		url: "http://localhost:8080/Clientes/" + cedula,
		dataType: "json",
		error: function (){
			alert("Error en la petición");		
		}		
	}).done(function(data){
		document.form2.input6.value=data.cedulaCliente
		document.form2.input7.value=data.nombreCliente
		document.form2.input8.value=data.direccionCliente
		document.form2.input9.value=data.telefonoCliente
		document.form2.input10.value=data.emailCliente
	})	
})

//DELETE= eliminar DELETE
$('table').on('click', '.btnEliminar',function(){
    var cedula = $(this).attr('id');
    $.ajax({
        type:"DELETE",
        url:"http://localhost:8080/Clientes/"+ cedula
    }).done(function(){
        location.reload();
    })
})
//PUT= actualizar UPDATE
$('#actualizarCliente').click(function(){
    
    //JSON
    var cliente={
        cedulaCliente: document.form2.input6.value,
        direccionCliente: document.form2.input8.value,
        emailCliente: document.form2.input10.value,
        nombreCliente: document.form2.input7.value,
        telefonoCliente: document.form2.input9.value,
    }
    $.ajax({
        type:"PUT",
        data:JSON.stringify(cliente), //esto permite convertir el string de user a objeto JSON
        url:"http://localhost:8080/Clientes/",
        contentType:"application/json"
    }) 
})

//POST= crear INSERT
$('#crearCliente').click(function(){
    //JSON
    var cliente={
    	cedulaCliente:document.form1.input1.value,
    	direccionCliente: document.form1.input3.value,
    	emailCliente: document.form1.input5.value,
    	nombreCliente: document.form1.input2.value,
    	telefonoCliente: document.form1.input4.value,
    }
    console.log(cliente)
    $.ajax({
        type:"POST",
        data:JSON.stringify(cliente), //esto permite convertir el string de user a objeto JSON
        url:"http://localhost:8080/Clientes/",
        contentType:"application/json"
    })    
})