package com.unbosque.DAO;
import com.unbosque.DTO.Usuario;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class UsuarioDAO {
	//creacion metodos del CRUD
	public ArrayList<Usuario> ListUser(){
		ArrayList<Usuario> usuarios=new ArrayList<Usuario>();
		Connection connection=new Connection();
		try {
			PreparedStatement statement=connection.getConnection().prepareStatement("SELECT * FROM usuarios");
			ResultSet result=statement.executeQuery();//executeQuery para consultas
			while(result.next()) {//el .next me va a recorrer linea por linea 
				Usuario usuario=new Usuario();
				usuario.setCedulaUsuario(Integer.parseInt(result.getString("cedula_usuario")));
				usuario.setEmailUsuario(result.getString("email_usuario"));
				usuario.setNombreUsuario(result.getString("nombre_usuario"));
				usuario.setPassword(result.getString("password"));
				usuario.setUsuario(result.getString("usuario"));
				
				usuarios.add(usuario);
			}
			result.close();
			statement.close();
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "No se pudo realizar la consulta\n"+e); //es como un sout de interfaz grafica
		}
		return usuarios;
	}

	public static void saveUser(Usuario usuario) {
		Connection connection=new Connection();
		try {
			String query="INSERT INTO usuarios VALUES (?,?,?,?,?)";
			PreparedStatement statement=connection.getConnection().prepareStatement(query);
			statement.setInt(1,usuario.getCedulaUsuario());
			statement.setString(2, usuario.getEmailUsuario());
			statement.setString(3, usuario.getNombreUsuario());
			statement.setString(4, usuario.getPassword());
			statement.setString(5, usuario.getUsuario());
		}catch(SQLException e) {
			e.getMessage();
		}
	}
	
	public Usuario readUserByID(int cedula) {
		Connection connection=new Connection();
		Usuario usuario=new Usuario();
		try {
			String query="SELECT * FROM usuarios WHERE cedula_usuario=?";
			PreparedStatement statement=connection.getConnection().prepareStatement(query);
			statement.setInt(1, cedula);
			ResultSet result=statement.executeQuery();
			while(result.next()) {
				usuario.setCedulaUsuario(Integer.parseInt(result.getString("cedula_usuario")));
				usuario.setEmailUsuario(result.getString("email_usuario"));
				usuario.setNombreUsuario(result.getString("nombre_usuario"));
				usuario.setPassword(result.getString("password"));
				usuario.setUsuario(result.getString("usuario"));
			}
			result.close();
			statement.close();
		}catch(SQLException e) {
			e.getMessage();
		}
		return usuario;
	}

	public static void updateUser(Usuario usuario) {
		Connection connection=new Connection();
		try {
			String query="UPDATE usuarios SET email_usuario=?, nombre_usuario=? WHERE cedula_usuario=?";
			PreparedStatement statement=connection.getConnection().prepareStatement(query);
			statement.setString(1, usuario.getEmailUsuario());
			statement.setString(2, usuario.getNombreUsuario());
			statement.setInt(3,usuario.getCedulaUsuario());
			statement.executeUpdate();
		}catch(SQLException e) {
			e.getMessage();
		}
	}

	public void deleteUser(int cedula) {
		Connection connection=new Connection();
		try {
			String query="DELETE FROM usuarios WHERE cedula_usuarios=?";
			PreparedStatement statement=connection.getConnection().prepareStatement(query);
			statement.setInt(1, cedula);
			statement.executeUpdate();
		}catch(SQLException e) {
			e.getMessage();
		}
	}
	
}
