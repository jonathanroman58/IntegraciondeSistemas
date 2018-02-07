package com.proyecto.ec.dao;

import java.util.List;
import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManagerFactory;
import com.proyecto.ec.domain.Paciente;

@Stateless
public class PacienteDaoImpl implements PacienteDao{

	
	public PacienteDaoImpl(){

	}
	
	@PersistenceContext
    private EntityManager em;

    public List<Paciente> findAllPaciente() {

        List<Paciente> hola = new ArrayList<Paciente>();
        try {
            hola = (List<Paciente>) em.createQuery("SELECT p FROM Paciente p").getResultList();
            System.out.println(hola);
            
        } catch(Exception e) {
//            e.printStackTrace();
        } finally {
            return hola;
        }
    }

    public Paciente findPacienteById(int id) {
        return em.find(Paciente.class, id);
    }
    
    public void insertPaciente(Paciente paciente) {
        em.persist(paciente);
    }


    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
    
}
