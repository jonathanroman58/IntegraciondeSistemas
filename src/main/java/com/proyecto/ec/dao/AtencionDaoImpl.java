package com.proyecto.ec.dao;

import java.util.List;
import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManagerFactory;
import com.proyecto.ec.domain.Atencion;
import com.proyecto.ec.domain.Enfermedad;

@Stateless
public class AtencionDaoImpl implements AtencionDao{
	
	public AtencionDaoImpl(){

	}
	
	@PersistenceContext
    private EntityManager em;

    public List<Atencion> findAllAtencion() {

        List<Atencion> hola = new ArrayList<Atencion>();
        try {
            hola = (List<Atencion>) em.createQuery("SELECT a FROM Atencion a").getResultList();
            System.out.println(hola);
            
        } catch(Exception e) {
//            e.printStackTrace();
        } finally {
            return hola;
        }
    }

    public Atencion findAtencionById(int id) {
        return em.find(Atencion.class, id);
    }
    
    public void insertAtencion(Atencion atencion) {
        em.persist(atencion);
    }


    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

}
