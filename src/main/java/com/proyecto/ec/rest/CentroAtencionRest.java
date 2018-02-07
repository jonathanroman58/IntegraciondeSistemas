package com.proyecto.ec.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.proyecto.ec.dao.CentroAtencionDao;
import com.proyecto.ec.domain.CentroAtencion;

@Stateful
@Path("/CentroAtencion")
public class CentroAtencionRest {

	@EJB
    protected CentroAtencionDao centroAtencionDao;
    
    @GET
    @Path("/GetCentroAtencion")
//	@Produces({MediaType.APPLICATION_JSON})
    public String getAllCentroAtencion() throws JsonProcessingException{
    	ObjectMapper objectMapper = new ObjectMapper();
    	objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

    	List<CentroAtencion> listaCentroAtencion = new ArrayList<CentroAtencion>();
    	listaCentroAtencion = centroAtencionDao.findAllCentroAtencion();
    	String arrayToJson = objectMapper.writeValueAsString(listaCentroAtencion);
        return arrayToJson;
    }
       
    @POST
    @Path("/buscarPorId")
    public String buscarPorId(String id) throws IOException{
    	ObjectMapper objectMapper = new ObjectMapper();
    	objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    	
    	CentroAtencion obj = new CentroAtencion();
    	obj =  objectMapper.readValue(id, CentroAtencion.class);
    	int id_CentroAtencion = obj.getIdcentroatencion();
    	
    	String arrayToJson = objectMapper.writeValueAsString(centroAtencionDao.findCentroAtencionById(id_CentroAtencion));
        return arrayToJson;
    }
    
    @POST
    @Path("/insertar")
    public boolean ingresarCentroAtencion(String json) throws IOException{
    	ObjectMapper objectMapper = new ObjectMapper();
    	objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    	
    	CentroAtencion obj = new CentroAtencion();
    	obj =  objectMapper.readValue(json, CentroAtencion.class);
    	centroAtencionDao.insertCentroAtencion(obj);
    	
        return true;
    }
	
}
