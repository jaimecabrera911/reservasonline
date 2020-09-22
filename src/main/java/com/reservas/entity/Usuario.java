package com.reservas.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idUsuario;
	private String username;
	private String password;

	@ManyToOne
	@JoinColumn(name = "id_rol")
	private Rol idRol;

	public Usuario() {
		super();
	}

	public Usuario(long idUsuario, String username, String password, Rol idRol) {
		super();
		this.idUsuario = idUsuario;
		this.username = username;
		this.password = password;
		this.idRol = idRol;
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Rol getIdRol() {
		return idRol;
	}

	public void setIdRol(Rol idRol) {
		this.idRol = idRol;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", username=" + username + ", password=" + password + ", idRol="
				+ idRol + "]";
	}

}
