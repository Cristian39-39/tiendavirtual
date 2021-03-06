package com.ubosque.tiendavirtual;


import com.ubosque.DAO.ClienteDAO;
import com.ubosque.DTO.Cliente;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Clientes")
public class ClienteController {
	ClienteDAO clienteDAO = new ClienteDAO();
		
	@GetMapping("/Lista")
	public ArrayList<Cliente> listaCliente(){
		return clienteDAO.ListaCliente();
	}
	
	@PostMapping
	public Cliente createCliente(@RequestBody Cliente cliente) {
		clienteDAO.saveCliente(cliente);
		return cliente;
	}
	
	@GetMapping(value="{cedula}")
	public Cliente clienteByID(@PathVariable("cedula")  int cedula) {
		return clienteDAO.readClienteByID(cedula);
	}

	@PutMapping()
	public Cliente updateCliente(@RequestBody Cliente cliente) {
		clienteDAO.updateCliente(cliente);
		return cliente;	
	}
	
	@DeleteMapping(value="{cedula}")
	public void deleteCliente(@PathVariable("cedula") int cedula) {
		clienteDAO.deleteCliente(cedula);
	}	
}