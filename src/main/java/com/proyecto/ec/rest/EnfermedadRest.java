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
import com.proyecto.ec.dao.EnfermedadDao;
import com.proyecto.ec.domain.Enfermedad;


@Stateful
@Path("/Enfermedad")
public class EnfermedadRest {
	@EJB
    protected EnfermedadDao enfermedadDao;
    
    @GET
    @Path("/GetEnfermedad")
//	@Produces({MediaType.APPLICATION_JSON})
    public String getAllPaciente() throws JsonProcessingException{
    	ObjectMapper objectMapper = new ObjectMapper();
    	objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

    	List<Enfermedad> listaEnfermedad = new ArrayList<Enfermedad>();
    	listaEnfermedad = enfermedadDao.findAllEnfermedad();
    	String arrayToJson = objectMapper.writeValueAsString(listaEnfermedad);
        return arrayToJson;
    }
       
    @POST
    @Path("/buscarPorId")
    public String buscarPorId(String id) throws IOException{
    	ObjectMapper objectMapper = new ObjectMapper();
    	objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    	
    	Enfermedad obj = new Enfermedad();
    	obj =  objectMapper.readValue(id, Enfermedad.class);
    	int id_enfermedad = obj.getIdenfermedad();
    	
    	String arrayToJson = objectMapper.writeValueAsString(enfermedadDao.findEnfermedadById(id_enfermedad));
        return arrayToJson;
    }
    
    @POST
    @Path("/insertar")
    public boolean ingresarEnfermedad(String json) throws IOException{
    	ObjectMapper objectMapper = new ObjectMapper();
    	objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    	
    	Enfermedad obj = new Enfermedad();
    	obj =  objectMapper.readValue(json, Enfermedad.class);
    	enfermedadDao.insertEnfermedad(obj);
    	
        return true;
    }
	
	
}
