package com.ubosque.DAO;

import com.ubosque.DAO.Connection;
import com.ubosque.DTO.Cliente;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ClienteDAO {

		//Creation CRUD
	public ArrayList<Cliente> ListaCliente(){
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		Connection connection = new Connection();
		
		try {
			PreparedStatement statement = connection.getConnection().prepareStatement("SELECT * FROM clientes");
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				 System.out.println("regreso de la base de datos");
				 Cliente cliente = new Cliente();
				 cliente.setCedulaCliente(Integer.parseInt(result.getString("cedula_cliente")));
				 cliente.setDireccionCliente(result.getString("direccion_cliente"));
				 cliente.setEmailCliente(result.getString("email_cliente"));
				 cliente.setNombreCliente(result.getString("nombre_cliente"));
				 cliente.setTelefonoCliente(result.getString("telefono_cliente"));
	             
		         clientes.add(cliente);
			}
			result.close();
			statement.close();
		}catch (SQLException e) {
			System.out.println("fallo la base de datos");
			JOptionPane.showMessageDialog(null, "no se pudo realizar la consulta\n"+e);
		}
		return clientes;				
	}

	public Cliente saveCliente(Cliente cliente) {
		Connection connection = new Connection();
		try {
			String query ="INSERT INTO clientes VALUES (?,?,?,?,?)";
			PreparedStatement statement = connection.getConnection().prepareStatement(query);
			statement.setInt(1, cliente.getCedulaCliente());
			statement.setString(2, cliente.getDireccionCliente());
			statement.setString(3, cliente.getEmailCliente());
			statement.setString(4, cliente.getNombreCliente());
			statement.setString(5, cliente.getTelefonoCliente());
			statement.executeUpdate();
			statement.close();
		}catch (SQLException e) {
			e.getMessage();
		}
		return cliente;
	}

	public Cliente readClienteByID(int cedula) {
		Connection connection = new Connection();
		Cliente cliente = new Cliente();
		try {
			String query = "SELECT * FROM clientes WHERE cedula_cliente=?";
				PreparedStatement statement = connection.getConnection().prepareStatement(query);
				statement.setInt(1,  cedula);
				ResultSet result= statement.executeQuery();
				while(result.next()) {
					cliente.setCedulaCliente(Integer.parseInt(result.getString("cedula_cliente")));
					cliente.setDireccionCliente(result.getString("direccion_cliente"));
					cliente.setEmailCliente(result.getString("email_cliente"));
					cliente.setNombreCliente(result.getString("nombre_cliente"));
					cliente.setTelefonoCliente(result.getString("telefono_cliente"));
				}
				result.close();
				statement.close();
			}catch (SQLException e) {
				e.getMessage();
			}
			return cliente;
		}
	
	public void updateCliente(Cliente cliente) {
		Connection connection = new Connection();
		try {
			String query = "UPDATE clientes SET nombre_cliente =?,direccion_cliente=?,telefono_cliente=?,email_cliente=? WHERE cedula_cliente=?";
			PreparedStatement statement = connection.getConnection().prepareStatement(query);
			statement.setString(1, cliente.getNombreCliente());
			statement.setString(2, cliente.getDireccionCliente());
			statement.setString(3, cliente.getTelefonoCliente());
			statement.setString(4, cliente.getEmailCliente());
			statement.setInt(5, cliente.getCedulaCliente());
			statement.executeUpdate();
			statement.close();
		}catch(SQLException e) {
			e.getMessage();
		}
	}
	
	public void deleteCliente(int cedula) {
		Connection connection = new Connection();
		try {
			String query = "DELETE FROM clientes WHERE cedula_cliente=?";
			PreparedStatement statement = connection.getConnection().prepareStatement(query);
			statement.setInt(1, cedula);
			statement.executeUpdate();
			statement.close();
		}catch(SQLException e) {
			e.getMessage();
		}
	}	
}
