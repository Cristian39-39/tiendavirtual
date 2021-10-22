package com.ubosque.tiendavirtual;



import java.util.ArrayList;
import com.ubosque.DTO.Producto;
import com.ubosque.DAO.ProductosDAO;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Productos")
public class productosController {

ProductosDAO productosDAO = new ProductosDAO();

@RequestMapping("/Lista")
public ArrayList<Producto> listaProductos(){

	return productosDAO.ListProducto();
}

@PostMapping
public Producto createProducto(@RequestBody Producto producto) {
	System.out.println(producto.getNombreProducto());
	productosDAO.saveProducto(producto);
	return producto;
}

@GetMapping(value="{codigo}")
public Producto productoByID(@PathVariable("codigo")  int codigo) {
	return productosDAO.readProductoByID(codigo);
}

@PutMapping()
public Producto updateProducto(@RequestBody Producto producto) {
	productosDAO.updateProducto(producto);
	return producto;	
}

@DeleteMapping(value="{codigo}")
public void deleteProducto(@PathVariable("codigo") int codigo) {
	productosDAO.deleteProducto(codigo);
}	
	
	
	
	
	
	
	
	
	
	
}
