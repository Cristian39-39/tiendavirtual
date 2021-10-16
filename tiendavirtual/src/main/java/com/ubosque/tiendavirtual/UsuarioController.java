package com.ubosque.tiendavirtual;
import com.ubosque.DAO.UsuarioDAO;
import com.ubosque.DTO.Usuario;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/Usuarios")
public class UsuarioController {
	UsuarioDAO usuarioDAO = new UsuarioDAO();
	@RequestMapping("/listarUsuarios")
	public ArrayList<Usuario> listaUsuario(){
		return usuarioDAO.ListUsers();
	}
	@PostMapping
	 public Usuario createUser() {
		Usuario usuario = new Usuario();
		usuario.setCedulaUsuario(5);
		usuario.setEmailUsuario("uncorreo");
		usuario.setNombreUsuario("usuario5");
		usuario.setPassword("password5");
		usuario.setUsuario("usuario5");
		usuarioDAO.saveUser(usuario);
		return usuario;
	}
	@GetMapping(value="{cedula}")
	public Usuario useByID(@PathVariable("cedula") int cedula) {
		return usuarioDAO.readUserByID(cedula);
	}
	@PutMapping
	 public Usuario updateUser() {
		Usuario usuario = new Usuario();
		usuario.setCedulaUsuario(5);
		usuario.setEmailUsuario("uncorreoModificado");
		usuario.setNombreUsuario("usuario5Modificado");
		usuario.setPassword("password5Modificado");
		usuario.setUsuario("usuario5Modificado");
		usuarioDAO.updateUser(usuario);
		return usuario;
	}
	@DeleteMapping(value="{cedula}")
	public void deleteUser(@PathVariable("cedula") int cedula) {
		usuarioDAO.deleteUser(cedula);
	}
}
