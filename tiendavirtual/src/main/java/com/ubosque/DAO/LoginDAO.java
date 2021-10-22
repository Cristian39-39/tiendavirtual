package com.ubosque.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ubosque.DTO.Login;
import com.ubosque.DTO.Status;

public class LoginDAO {
	
private static String userMaster = "admininicial";
private static String passwordMaster = "admin123456";

	public static Status loginReques(Login login) {
		Connection connection = new Connection();
		Status status = new Status();
		if(login.getUsuario().contentEquals(userMaster)&login.getPassword().contentEquals(passwordMaster)) {
			status.setUsuario(userMaster);
			status.setStatus(true);
		}else {
			try {
				String query = "SELECT password FROM usuarios WHERE nombre_usuario=?";
				PreparedStatement statement = connection.getConnection().prepareStatement(query);
				statement.setString(1, login.getUsuario());
				ResultSet result = statement.executeQuery();
				while(result.next()) {
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
		}
		return status;
	}
}