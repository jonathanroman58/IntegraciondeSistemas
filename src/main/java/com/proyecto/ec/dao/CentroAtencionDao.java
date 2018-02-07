package com.proyecto.ec.dao;

import java.util.List;

import javax.ejb.Local;

import com.proyecto.ec.domain.CentroAtencion;

@Local
public interface CentroAtencionDao {
	
	public List<CentroAtencion> findAllCentroAtencion();
	
	public CentroAtencion findCentroAtencionById(int id);
	
	public void insertCentroAtencion(CentroAtencion centroAtencion);

}
