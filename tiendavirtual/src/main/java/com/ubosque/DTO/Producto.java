package com.ubosque.DTO;

public class Producto {

	
	private int codigoProducto;
	private String nombreProducto; 
	private int nitproveedor;
	private double precioCompra;
	private double ivacompra;
	private double precioVenta;
	
	public int getCodigoProducto() {
		return codigoProducto;
	}
	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public int getNitproveedor() {
		return nitproveedor;
	}
	public void setNitproveedor(int nitproveedor) {
		this.nitproveedor = nitproveedor;
	}
	public double getPrecioCompra() {
		return precioCompra;
	}
	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}
	public double getIvacompra() {
		return ivacompra;
	}
	public void setIvacompra(double ivacompra) {
		this.ivacompra = ivacompra;
	}
	public double getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}
	
	
}