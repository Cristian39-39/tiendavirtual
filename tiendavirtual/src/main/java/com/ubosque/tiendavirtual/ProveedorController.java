package com.ubosque.tiendavirtual;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ubosque.DAO.ProveedorDAO;
import com.ubosque.DAO.UsuarioDAO;
import com.ubosque.DTO.Proveedor;
import com.ubosque.DTO.Usuario;


@RestController
@RequestMapping("/Proveedores")
public class ProveedorController {
	ProveedorDAO proveedorDAO = new ProveedorDAO();
	
	UsuarioDAO usuarioDAO = new UsuarioDAO();
	
	@RequestMapping("/Lista")
	public ArrayList<Proveedor> listaProveedores(){
		
		return proveedorDAO.ListProv();
}
	
	@PostMapping
	public Proveedor createProveedor(@RequestBody Proveedor proveedor) {
		proveedorDAO.saveProveedor(proveedor);
		return proveedor;
	}
	
	@GetMapping(value="{nit}")
	public Proveedor proveedorByID(@PathVariable("nit")  int nit) {
		return proveedorDAO.readProveedorByID(nit);
	}

	@PutMapping()
	public Proveedor updateProveedor(@RequestBody Proveedor proveedor) {
		proveedorDAO.updateProveedor(proveedor);
		return proveedor;	
	}
	
	@DeleteMapping(value="{nit}")
	public void deleteUser(@PathVariable("nit") int nit) {
		proveedorDAO.deleteProveedor(nit);
	}	
}
