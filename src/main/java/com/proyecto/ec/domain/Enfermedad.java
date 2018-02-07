package com.proyecto.ec.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "Enfermedad" database table.
 * 
 */
@Entity
@Table(name="\"Enfermedad\"")
@NamedQuery(name="Enfermedad.findAll", query="SELECT e FROM Enfermedad e")
public class Enfermedad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idenfermedad;

	private String gravedad;

	private String nombre;

	

	public Enfermedad() {
	}

	public Integer getIdenfermedad() {
		return this.idenfermedad;
	}

	public void setIdenfermedad(Integer idenfermedad) {
		this.idenfermedad = idenfermedad;
	}

	public String getGravedad() {
		return this.gravedad;
	}

	public void setGravedad(String gravedad) {
		this.gravedad = gravedad;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	

}