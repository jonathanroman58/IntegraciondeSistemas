package com.proyecto.ec.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "Paciente" database table.
 * 
 */
@Entity
@Table(name="\"Paciente\"")
@NamedQuery(name="Paciente.findAll", query="SELECT p FROM Paciente p")
public class Paciente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idpaciente;

	@Column(name="\"FechaNacimiento\"")
	private String fechaNacimiento;

	@Column(name="\"Latitud\"")
	private String latitud;

	@Column(name="\"Longitud\"")
	private String longitud;

	@Column(name="\"Nombre\"")
	private String nombre;

	
	public Paciente() {
	}

	public Integer getIdpaciente() {
		return this.idpaciente;
	}

	public void setIdpaciente(Integer idpaciente) {
		this.idpaciente = idpaciente;
	}

	public String getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getLatitud() {
		return this.latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return this.longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	

}