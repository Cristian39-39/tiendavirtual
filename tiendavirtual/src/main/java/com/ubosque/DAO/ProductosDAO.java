package com.ubosque.DAO;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import com.ubosque.DTO.Producto;

public class ProductosDAO {
//Creation CRUD
	
public ArrayList<Producto> ListProducto(){
		ArrayList<Producto> productos = new ArrayList<Producto>();
		Connection connection = new Connection();
		
		try {
			PreparedStatement statement = connection.getConnection().prepareStatement("SELECT * FROM productos");
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				Producto producto = new Producto();
				producto.setCodigoProducto(Integer.parseInt(result.getString("codigo_producto")));
				producto.setNombreProducto(result.getString("nombre_producto"));
				producto.setNitproveedor(Integer.parseInt(result.getString("nitproveedor")));
				producto.setPrecioCompra(Double.parseDouble (result.getString("precio_compra")));
				producto.setIvacompra(Double.parseDouble (result.getString("ivacompra")));
				producto.setPrecioVenta(Double.parseDouble (result.getString("precio_venta")));


	             productos.add(producto);
			}
			result.close();
			statement.close();
		}catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, "no se pudo realizar la consulta\n"+e);
		}
		return productos;
}
		
		public Producto saveProducto(Producto producto) {
			Connection connection = new Connection();
			try {
				String query ="INSERT INTO productos VALUES (?,?,?,?,?,?)";
				PreparedStatement statement = connection.getConnection().prepareStatement(query);
				statement.setInt(1, producto.getCodigoProducto());
				statement.setString(2, producto.getNombreProducto());
				statement.setInt(3, producto.getNitproveedor());
				statement.setDouble(4, producto.getPrecioCompra());
				statement.setDouble(5, producto.getIvacompra());
				statement.setDouble(6, producto.getPrecioVenta());

				statement.executeUpdate();
				statement.close();
			}catch (SQLException e) {
				System.out.println("SIRVIO");
				e.getMessage();
			}
			return producto;		
		}
	

		public Producto readProductoByID(int codigo) {
			Connection connection = new Connection();
			Producto producto = new Producto();
			try {
				String query = "SELECT * FROM productos WHERE codigo_producto=?";
				PreparedStatement statement = connection.getConnection().prepareStatement(query);
				statement.setInt(1,  codigo);
				ResultSet result= statement.executeQuery();
				while(result.next()) {
					producto.setCodigoProducto(Integer.parseInt(result.getString("codigo_producto")));
					producto.setNombreProducto(result.getString("nombre_producto"));
					producto.setNitproveedor(Integer.parseInt(result.getString("nitproveedor")));
					producto.setPrecioCompra(Double.parseDouble (result.getString("precio_compra")));
					producto.setIvacompra(Double.parseDouble (result.getString("ivacompra")));
					producto.setPrecioVenta(Double.parseDouble (result.getString("precio_venta")));
				}
				result.close();
				statement.close();
			}catch (SQLException e) {
				e.getMessage();
			}
			return producto;
		}
		
		public void updateProducto(Producto producto) {
			Connection connection = new Connection();
			try {
				String query = "UPDATE productos SET nombre_producto=?,nitproveedor=?,precio_compra=?,ivacompra=?, precio_venta=? WHERE codigo_producto=?";
				PreparedStatement statement = connection.getConnection().prepareStatement(query);
				statement.setString(1, producto.getNombreProducto());
				statement.setInt(2, producto.getNitproveedor());
				statement.setDouble(3, producto.getPrecioCompra());
				statement.setDouble(4, producto.getIvacompra());
				statement.setDouble(5, producto.getPrecioVenta());
				statement.setInt(6, producto.getCodigoProducto());

				statement.executeUpdate();
				statement.close();
			}catch(SQLException e) {
				e.getMessage();
			}

		}
		
		public void deleteProducto(int codigo) {
			Connection connection = new Connection();
			try {
				String query = "DELETE FROM productos WHERE codigo_producto=?";
				PreparedStatement statement = connection.getConnection().prepareStatement(query);
				statement.setInt(1, codigo);
				statement.executeUpdate();
				statement.close();
			}catch(SQLException e) {
				e.getMessage();
			}

		}	
}
	
	
	
	
	
	

