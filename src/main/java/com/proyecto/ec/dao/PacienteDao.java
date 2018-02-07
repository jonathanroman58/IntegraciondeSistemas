package com.proyecto.ec.dao;

import java.util.List;

import javax.ejb.Local;

import com.proyecto.ec.domain.Paciente;

@Local
public interface PacienteDao {

		public List<Paciente> findAllPaciente();
		
		public Paciente findPacienteById(int id);
		
		public void insertPaciente(Paciente paciente);
		
}
