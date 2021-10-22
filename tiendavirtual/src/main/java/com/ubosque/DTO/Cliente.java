package com.ubosque.DTO;

public class Cliente {
		private int cedulaCliente;
		private String nombreCliente;
		private String dirreccionCliente;
		private String telefonoCliente;
		private String emailCliente;

		
		//Método getter and setter
		
		public int getCedulaCliente() {
			return cedulaCliente;
		}
		public void setCedulaCliente(int cedulaCliente) {
			this.cedulaCliente = cedulaCliente;
		}
		public String getNombreCliente() {
			return nombreCliente;
		}
		public void setNombreCliente(String nombreCliente) {
			this.nombreCliente= nombreCliente;
		}
		public String getDirreccionCliente() {
			return dirreccionCliente;
		}
		public void setDirreccionCliente(String dirreccionCliente) {
			this.dirreccionCliente = dirreccionCliente;
		}
		public String getTelefonoCliente() {
			return telefonoCliente;
		}
		public void setTelefonoCliente(String telefonoCliente) {
			this.telefonoCliente = telefonoCliente;
		}
		public String getEmailCliente() {
			return emailCliente;
		}
		public void setEmailCliente(String emailCliente) {
			this.emailCliente = emailCliente;
		}
	}
