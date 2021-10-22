/**
 * 
 */
var saveme =  $.ajax({
        type: "GET",
        url: "http://localhost:8080/Productos/Lista", //ruta de la API consultaremos.
      
        success: function(data) {
        	console.log(data)
          $.each(data, function(i, item) {
	          lista = document.getElementById("cuerpoTabla");
	          var tr = document.createElement("tr");
			  var idtr = document.createAttribute("id")
			  idtr.value=item.codigoProducto;
			  tr.setAttributeNode(idtr);
	
	          var columna1 = document.createElement("th");
	          columna1.innerHTML = item.codigoProducto;
	          var columna2 = document.createElement("th");
	          columna2.innerHTML = item.nombreProducto;
	          var columna3 = document.createElement("th");
	          columna3.innerHTML = item.nitproveedor;
	          var columna4 = document.createElement("th");
	          columna4.innerHTML = item.precioCompra;
	          var columna5 = document.createElement("th");
	          columna5.innerHTML = item.ivacompra;
	          var columna6 = document.createElement("th");
	          columna6.innerHTML = item.precioVenta;

			  var columna7 = document.createElement("th");
			  //
				var button = document.createElement("button");
				var idButton = document.createAttribute("id");
				idButton.value = item.codigoProducto;
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
				idButton2.value = item.codigoProducto;
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
			  tr.appendChild(columna7);
              columna7.appendChild(button);
			  button.appendChild(icon);
	          columna7.appendChild(button2);
			  button2.appendChild(icon2);

             
	       
         });
      }
 });

$('table').on('click','.btnConsultar', function(){
	var codigo = $(this).attr('id')
	$.ajax({
		
		type: "GET",
		url: "http://localhost:8080/Productos/"+codigo,
		dataType: "json",
		error: function (){
			alert("Error en la petición");
			
		}
		
	}).done(function(data){
		document.form2.input7.value=data.codigoProducto
		document.form2.input8.value=data.nombreProducto
		document.form2.input9.value=data.nitproveedor
		document.form2.input10.value=data.precioCompra
		document.form2.input11.value=data.ivacompra
		document.form2.input12.value=data.precioVenta
	})	
})

//DELETE= eliminar DELETE
$('table').on('click', '.btnEliminar',function(){
    var codigo=$(this).attr('id');
    $.ajax({
        type:"DELETE",
        url:"http://localhost:8080/Productos/"+codigo
    }).done(function(){
        location.reload();
    })
})
//PUT= actualizar UPDATE
$('#actualizarProducto').click(function(){
 
    
    //JSON
    var product={
    codigoProducto:document.form2.input7.value,
        nombreProducto: document.form2.input8.value,
          nitproveedor: document.form2.input9.value,
          precioCompra: document.form2.input10.value,
          ivacompra: document.form2.input11.value,
          precioVenta: document.form2.input12.value
    }
    $.ajax({
        type:"POST",
        data:JSON.stringify(product), //esto permite convertir el string de user a objeto JSON
        url:"http://localhost:8080/Productos/",
        contentType:"application/json"
    })
    
})

  



   

//POST= crear INSERT
$('#crearProducto').click(function(){
	
 
    
    //JSON
    var product={
       codigoProducto:document.form1.input1.value,
        nombreProducto: document.form1.input2.value,
          nitproveedor: document.form1.input3.value,
          precioCompra: document.form1.input4.value,
          ivacompra: document.form1.input5.value,
          precioVenta: document.form1.input6.value
    }
    $.ajax({
        type:"POST",
        data:JSON.stringify(product), //esto permite convertir el string de user a objeto JSON
        url:"http://localhost:8080/Productos/",
        contentType:"application/json"
    })
    
})

     