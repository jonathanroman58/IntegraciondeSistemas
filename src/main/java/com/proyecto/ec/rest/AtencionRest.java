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
import com.proyecto.ec.dao.AtencionDao;
import com.proyecto.ec.domain.Atencion;

@Stateful
@Path("/Atencion")
public class AtencionRest {
	@EJB
    protected AtencionDao atencionDao;
    
    @GET
    @Path("/GetAtencion")
//	@Produces({MediaType.APPLICATION_JSON})
    public String getAllPaciente() throws JsonProcessingException{
    	ObjectMapper objectMapper = new ObjectMapper();
    	objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

    	List<Atencion> listaAtencion = new ArrayList<Atencion>();
    	listaAtencion = atencionDao.findAllAtencion();
    	String arrayToJson = objectMapper.writeValueAsString(listaAtencion);
        return arrayToJson;
    }
       
    @POST
    @Path("/buscarPorId")
    public String buscarPorId(String id) throws IOException{
    	ObjectMapper objectMapper = new ObjectMapper();
    	objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    	
    	Atencion obj = new Atencion();
    	obj =  objectMapper.readValue(id, Atencion.class);
    	int id_atencion = obj.getIdatencion();
    	
    	String arrayToJson = objectMapper.writeValueAsString(atencionDao.findAtencionById(id_atencion));
        return arrayToJson;
    }
    
    @POST
    @Path("/insertar")
    public boolean ingresarEnfermedad(String json) throws IOException{
    	ObjectMapper objectMapper = new ObjectMapper();
    	objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    	
    	Atencion obj = new Atencion();
    	obj =  objectMapper.readValue(json, Atencion.class);
    	atencionDao.insertAtencion(obj);
    	
        return true;
    }
}
