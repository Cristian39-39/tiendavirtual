package com.ubosque.tiendavirtual;
import com.unbosque.DAO.UsuarioDAO;

import com.unbosque.DTO.Usuario;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/Usuarios")
public class UsuarioController {
	UsuarioDAO usuarioDAO=new UsuarioDAO();
	@RequestMapping("/Lista")
	public ArrayList<Usuario> listarUsuario(){
		return usuarioDAO.ListUser();
	}
	
	//HTTP = HyperText Transfer Protocol
	//Create= POST
	@PostMapping
	public Usuario createUser() {
		Usuario usuario=new Usuario();
		usuario.setCedulaUsuario(2);
		usuario.setEmailUsuario("adriana@gmail.com");
		usuario.setNombreUsuario("adriana");
		usuario.setPassword("12345");
		usuario.setUsuario("usuario2");
		UsuarioDAO.saveUser(usuario);
		return usuario;
	}
	
	//Read = GET
	@GetMapping(value="{cedula}") //localhost:8080/Usuarios/3
	public Usuario userByID(@PathVariable("cedula")int cedula) {
		return usuarioDAO.readUserByID(cedula);
	}
	
	//Update = PUT
	@PutMapping
	public Usuario updateUser() {
		Usuario usuario=new Usuario();
		usuario.setCedulaUsuario(34454);
		usuario.setEmailUsuario("adriana@gmail.com");
		usuario.setNombreUsuario("adriana");
		usuario.setPassword("12345");
		usuario.setUsuario("usuario2");
		usuarioDAO.updateUser(usuario);
		return usuario;
	}
	
	//Delete= DELETE
	@DeleteMapping(value="{cedula}")
	public void deleteUser(@PathVariable("cedula")int cedula) {
		usuarioDAO.deleteUser(cedula)
	}
	
}
