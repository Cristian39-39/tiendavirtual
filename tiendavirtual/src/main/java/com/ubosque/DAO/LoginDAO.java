package com.ubosque.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ubosque.DTO.Login;
import com.ubosque.DTO.Status;

public class LoginDAO {

	public static Status loginReques(Login login) {
		Connection connection = new Connection();
		Status status = new Status();

		
		try {
			String query = "SELECT password FROM usuarios WHERE nombre_usuario=?";
			PreparedStatement statement = connection.getConnection().prepareStatement(query);
			statement.setString(1, login.getUsuario());
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				System.out.println(login.getPassword());
				System.out.println(result.getString("password"));
				status.setUsuario(login.getUsuario());
				if(result.getString("password").equals(login.getPassword())) {
					status.setStatus(true);	
				}else {
					status.setStatus(false);	
				}
			}
			result.close();
			statement.close();
		}catch(SQLException e){
			e.getMessage();
		}	
		return status;
	}

}
