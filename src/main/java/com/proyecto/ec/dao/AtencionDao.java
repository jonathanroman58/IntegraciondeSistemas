package com.proyecto.ec.dao;

import java.util.List;

import javax.ejb.Local;

import com.proyecto.ec.domain.Atencion;

@Local
public interface AtencionDao {
	
	public List<Atencion> findAllAtencion();
	
	public Atencion findAtencionById(int id);
	
	public void insertAtencion(Atencion atencion);

}
