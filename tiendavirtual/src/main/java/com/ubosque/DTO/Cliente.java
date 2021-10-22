package com.ubosque.DTO;

public class Cliente {
	private int cedulaCliente;
	private String direccionCliente;
	private String emailCliente;
	private String nombreCliente;
	private String telefonoCliente;
	
	
	//Método getter and setter
	public int getCedulaCliente() {
		return cedulaCliente;
	}
	public void setCedulaCliente(int cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}
	public String getDireccionCliente() {
		return direccionCliente;
	}
	public void setDireccionCliente(String dirreccionCliente) {
		this.direccionCliente = dirreccionCliente;
	}
	public String getEmailCliente() {
		return emailCliente;
	}
	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getTelefonoCliente() {
		return telefonoCliente;
	}
	public void setTelefonoCliente(String telefonoCliente) {
		this.telefonoCliente = telefonoCliente;
	}	
}