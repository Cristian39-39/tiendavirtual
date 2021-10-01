package com.unbosque.DAO;
import java.sql.SQLException;
import java.sql.DriverManager;
public class Connection {
    String database="tienda";
    String user="root";
    String password="admin";
    String url= "jdbc:mysql://localhost/"+database;
    java.sql.Connection Connection = null;
    
    
    public java.sql.Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection=DriverManager.getConnection(url, user, password);
            if(Connection!=null) {
                System.out.println("Conexión exitosa a la base de datos");
            }
        }catch(SQLException e){
            e.getMessage();
        }catch(ClassNotFoundException e) {
            e.getMessage();
        }
        return Connection;
    }
}
