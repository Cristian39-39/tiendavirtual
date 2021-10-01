/**
 * 
 */
var saveme =  $.ajax({
        type: "POST",
        url: "http://localhost:8080/Usuarios/Lista", //ruta de la API consultaremos.
      
        success: function(data) {
          $.each(data, function(i, item) {
          lista = document.getElementById("cuerpoTabla");
          var tr = document.createElement("tr");
          var columna1 = document.createElement("td")
          columna1.innerHTML = item.cedulaUsuario;
		  var columna2 = document.createElement("td")
          columna2.innerHTML = item.emailUsuario;
          var columna3 = document.createElement("td")
          columna3.innerHTML = item.nombreUsuario;
          var columna4 = document.createElement("td")
          columna4.innerHTML = item.password;
		  var columna5 = document.createElement("td")
          columna5.innerHTML = item.usuario;
        
          lista.appendChild(tr);
          tr.appendChild(columna1);
          tr.appendChild(columna2);
          tr.appendChild(columna3);
		  tr.appendChild(columna4);
		  tr.appendChild(columna5);
       
         });
        }
      });