package com.ubosque.tiendavirtual;
import com.ubosque.DAO.UsuarioDAO;
import com.ubosque.DTO.Usuario;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController

@RequestMapping("/Usuarios")
public class UsuarioController {
	UsuarioDAO usuarioDAO = new UsuarioDAO();
	
	@RequestMapping("/Lista")
	public ArrayList<Usuario> listaUsuario(){
		
		return usuarioDAO.ListUsers();
}
	
	@PostMapping
	public Usuario createUser() {
		Usuario usuario = new Usuario();
		usuario.setCedulaUsuario(4);
		usuario.setEmailUsuario("usuario@prueba.com");
		usuario.setNombreUsuario("nombre_usuario");
		usuario.setPassword("123");
		usuario.setUsuario("usuario04");
		usuarioDAO.saveUser(usuario);
		return usuario;
	}
	
	@GetMapping(value="{cedula}")
	public Usuario userByID(@PathVariable("cedula")  int cedula) {
		return usuarioDAO.readUserByID(cedula);
	}

	@PutMapping
	public Usuario updateUser() {
		Usuario usuario = new Usuario();
		
		usuarioDAO.updateUser(usuario);
		return usuario;
		
	//@DeleteMapping	
		
		
	}
	
	
	
}
