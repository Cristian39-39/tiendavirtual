/**
 * 
 */

var saveme =  $.ajax({
        type: "GET",
        url: "http://localhost:8080/Proveedores/Lista", //ruta de la API consultaremos.
      
        success: function(data) {
          $.each(data, function(i, item) {
	          lista = document.getElementById("cuerpoTabla");
	          var tr = document.createElement("tr");
			  var idtr = document.createAttribute("id")
			  idtr.value=item.nitProveedor;
			  tr.setAttributeNode(idtr);
	
	          var columna1 = document.createElement("th");
	          columna1.innerHTML = item.nitProveedor;
	          var columna2 = document.createElement("th");
	          columna2.innerHTML = item.ciudadProveedor;
	          var columna3 = document.createElement("th");
	          columna3.innerHTML = item.direccionProveedor;
	          var columna4 = document.createElement("th");
	          columna4.innerHTML = item.nombreProveedor;
	          var columna5 = document.createElement("th");
	          columna5.innerHTML = item.telefonoProveedor;

			  var columna6 = document.createElement("th");
			  //
				var button = document.createElement("button");
				var idButton = document.createAttribute("id");
				idButton.value = item.nitProveedor;
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
				idButton2.value = item.nitProveedor;
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
	var nit = $(this).attr('id')
	$.ajax({
		type: "GET",
		url: "http://localhost:8080/Proveedores/"+nit,
		dataType: "json",
		error: function (){
			alert("Error en la petición");
			
		}
		
		
	}).done(function(data){
		document.form2.input6.value=data.nitProveedor
		document.form2.input7.value=data.ciudadProveedor
		document.form2.input8.value=data.direccionProveedor
		document.form2.input9.value=data.nombreProveedor
		document.form2.input10.value=data.telefonoProveedor
	})	
})

//DELETE= eliminar DELETE
$('table').on('click', '.btnEliminar',function(){
    var nit=$(this).attr('id');
    $.ajax({
        type:"DELETE",
        url:"http://localhost:8080/Proveedores/"+nit
    }).done(function(){
        location.reload();
    })
})
//PUT= actualizar UPDATE
$('#actualizarUsuario').click(function(){

    
    //JSON
    var prov={
        nitProveedor:document.form2.input6.value,
        ciudadProveedor: document.form2.input7.value,
        direccionProveedor: document.form2.input8.value,
        nombreProveedor: document.form2.input9.value,
        telefonoProveedor: document.form2.input10.value
    }
    $.ajax({
        type:"PUT",
        data:JSON.stringify(prov), //esto permite convertir el string de user a objeto JSON
        url:"http://localhost:8080/Proveedores/",
        contentType:"application/json"
    }) 
})

//POST= crear INSERT
$('#crearUsuario').click(function(){
    //JSON
    var prov={
    	nitProveedor:document.form1.input1.value,
    	ciudadProveedor: document.form1.input2.value,
    	direccionProveedor: document.form1.input3.value,
    	nombreProveedor: document.form1.input4.value,
    	telefonoProveedor: document.form1.input5.value
    }
    $.ajax({
        type:"POST",
        data:JSON.stringify(prov), //esto permite convertir el string de user a objeto JSON
        url:"http://localhost:8080/Proveedores/",
        contentType:"application/json"
    })    
})