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
import com.proyecto.ec.dao.PacienteDao;
import com.proyecto.ec.domain.Paciente;

@Stateful
@Path("/Paciente")
public class PacienteRest {
	@EJB
    protected PacienteDao pacienteDao;
    
    @GET
    @Path("/GetPacientes")
//	@Produces({MediaType.APPLICATION_JSON})
    public String getAllPaciente() throws JsonProcessingException{
    	ObjectMapper objectMapper = new ObjectMapper();
    	objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

    	List<Paciente> listaPaciente = new ArrayList<Paciente>();
    	listaPaciente = pacienteDao.findAllPaciente();
    	String arrayToJson = objectMapper.writeValueAsString(listaPaciente);
        return arrayToJson;
    }
       
    @POST
    @Path("/buscarPorId")
    public String buscarPorId(String id) throws IOException{
    	ObjectMapper objectMapper = new ObjectMapper();
    	objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    	
    	Paciente obj = new Paciente();
    	obj =  objectMapper.readValue(id, Paciente.class);
    	int id_paciente = obj.getIdpaciente();
    	
    	String arrayToJson = objectMapper.writeValueAsString(pacienteDao.findPacienteById(id_paciente));
        return arrayToJson;
    }
    
    @POST
    @Path("/insertar")
    public String ingresarPaciente(String json) throws IOException{
    	ObjectMapper objectMapper = new ObjectMapper();
    	objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    	
    	Paciente obj = new Paciente();
    	obj =  objectMapper.readValue(json, Paciente.class);
    	pacienteDao.insertPaciente(obj);
    	
    	String arrayToJson = objectMapper.writeValueAsString(true);
        return arrayToJson;
    }
	
	

}
