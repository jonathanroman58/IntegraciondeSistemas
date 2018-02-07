package com.proyecto.ec.dao;

import java.util.List;

import javax.ejb.Local;

import com.proyecto.ec.domain.Enfermedad;

@Local
public interface EnfermedadDao {
	
	public List<Enfermedad> findAllEnfermedad();
	
	public Enfermedad findEnfermedadById(int id);
	
	public void insertEnfermedad(Enfermedad enfermedad);

}
