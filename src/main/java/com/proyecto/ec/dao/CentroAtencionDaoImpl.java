package com.proyecto.ec.dao;

import java.util.List;
import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManagerFactory;
import com.proyecto.ec.domain.CentroAtencion;

@Stateless
public class CentroAtencionDaoImpl implements CentroAtencionDao {
	
	public CentroAtencionDaoImpl(){

	}
	
	@PersistenceContext
    private EntityManager em;

    public List<CentroAtencion> findAllCentroAtencion() {

        List<CentroAtencion> hola = new ArrayList<CentroAtencion>();
        try {
            hola = (List<CentroAtencion>) em.createQuery("SELECT c FROM CentroAtencion c").getResultList();
            System.out.println(hola);
            
        } catch(Exception e) {
//            e.printStackTrace();
        } finally {
            return hola;
        }
    }

    public CentroAtencion findCentroAtencionById(int id) {
        return em.find(CentroAtencion.class, id);
    }
    
    public void insertCentroAtencion(CentroAtencion centroAtencion) {
        em.persist(centroAtencion);
    }


    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

}
