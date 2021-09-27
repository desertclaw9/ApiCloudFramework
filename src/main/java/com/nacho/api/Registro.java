package com.nacho.api;

import javax.ws.rs.Consumes;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/") 
public class Registro {  
	
	private Integer idCont = 1;

    @POST 
    @Path("register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response register(@Context HttpHeaders headers, User user) { 
    	
    	String webKey = "";
    	
    	try {
    		webKey = headers.getRequestHeader("X-WEB-KEY").get(0);
    	}
    	catch(NullPointerException e) {
    		return Response.status(Response.Status.BAD_REQUEST).build();
    	}
    	
    	if (!webKey.equals("Test2021") || user == null) {
    		return Response.status(Response.Status.BAD_REQUEST).build();
    	}
    	
    	if (user.getName()==null || user.getSurname()==null || user.getEmail()==null || user.getPhone()==0) {
    		return Response.status(Response.Status.BAD_REQUEST).build();
    	}
    	
    	Success response = new Success(true, "id"+idCont);
    	this.idCont += 1;
    	
        return Response.status(Response.Status.CREATED).entity(response).build();
        
    } 
    
    @GET 
    @Path("check")
    @Produces(MediaType.APPLICATION_JSON)
    public Response check(@Context HttpHeaders headers) { 
    	
    	String webKey="";
    	String dsToken="";
    	
    	try {
    		webKey = headers.getRequestHeader("X-WEB-KEY").get(0);
    		dsToken = headers.getRequestHeader("X-DS-TOKEN").get(0);
    	}
    	catch(NullPointerException e) {    	
    		
    	}
    	
    	if (!webKey.equals("Test2021")) {
    		return Response.status(Response.Status.BAD_REQUEST).build();
    	}
    	
    	if (dsToken=="") {
    		Success response = new Success(false);
    		return Response.status(Response.Status.UNAUTHORIZED).entity(response).build();
    	}
    	   	
    	Success response = new Success(true);
    	return Response.status(Response.Status.OK).entity(response).build();
    	
    	
    }
}





