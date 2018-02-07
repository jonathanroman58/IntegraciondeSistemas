package com.proyecto.ec.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the atencion database table.
 * 
 */
@Entity
@NamedQuery(name="Atencion.findAll", query="SELECT a FROM Atencion a")
public class Atencion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idatencion;

	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@Column(name="\"idcentroatencion\"")
	private int idcentroatencion;

	@Column(name="\"idenfermedad\"")
	private int idenfermedad;

	@Column(name="\"idpaciente\"")
	private int idpaciente;
	

	public Atencion() {
	}

	public Integer getIdatencion() {
		return this.idatencion;
	}

	public void setIdatencion(Integer idatencion) {
		this.idatencion = idatencion;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getIdcentroatencion() {
		return idcentroatencion;
	}

	public void setIdcentroatencion(int idcentroatencion) {
		this.idcentroatencion = idcentroatencion;
	}

	public int getIdenfermedad() {
		return idenfermedad;
	}

	public void setIdenfermedad(int idenfermedad) {
		this.idenfermedad = idenfermedad;
	}

	public int getIdpaciente() {
		return idpaciente;
	}

	public void setIdpaciente(int idpaciente) {
		this.idpaciente = idpaciente;
	}


	
}