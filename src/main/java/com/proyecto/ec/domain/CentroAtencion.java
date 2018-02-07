package com.proyecto.ec.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "CentroAtencion" database table.
 * 
 */
@Entity
@Table(name="\"CentroAtencion\"")
@NamedQuery(name="CentroAtencion.findAll", query="SELECT c FROM CentroAtencion c")
public class CentroAtencion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idcentroatencion;

	private String direccion;

	private String nombre;

	
	public CentroAtencion() {
	}

	public Integer getIdcentroatencion() {
		return this.idcentroatencion;
	}

	public void setIdcentroatencion(Integer idcentroatencion) {
		this.idcentroatencion = idcentroatencion;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	

	

}