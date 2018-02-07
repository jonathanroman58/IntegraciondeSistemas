package com.proyecto.ec.dao;

import java.util.List;
import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManagerFactory;
import com.proyecto.ec.domain.Enfermedad;


@Stateless
public class EnfermedadDaoImpl implements EnfermedadDao{
	
	public EnfermedadDaoImpl(){

	}
	
	@PersistenceContext
    private EntityManager em;

    public List<Enfermedad> findAllEnfermedad() {

        List<Enfermedad> hola = new ArrayList<Enfermedad>();
        try {
            hola = (List<Enfermedad>) em.createQuery("SELECT e FROM Enfermedad e").getResultList();
            System.out.println(hola);
            
        } catch(Exception e) {
//            e.printStackTrace();
        } finally {
            return hola;
        }
    }

    public Enfermedad findEnfermedadById(int id) {
        return em.find(Enfermedad.class, id);
    }
    
    public void insertEnfermedad(Enfermedad enfermedad) {
        em.persist(enfermedad);
    }


    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

}
