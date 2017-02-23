package com.ibm.ff.rest.services;


import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import com.cloudant.http.interceptors.BasicAuthInterceptor;
import com.ibm.ff.dbfactory.*;

@ApplicationPath("/")
@Path("admin")
public class AdminServices extends Application {
    @GET
    @Path("test")
	@Produces("application/json")
	public String getString() {
    	return "Test";
	}
    

    @GET
    @Path("createDB/{DBName}")
	@Produces("application/json")
	public String createDB(@PathParam("DBName") String DBName) {
    	cloudant c = new cloudant();
    	c.login();
    	c.createDB(DBName);
    	
		return c.toString();
	}
    
    @POST
    @Path("createDocument/{DBName}")
    @Consumes("application/json")
	@Produces("application/json")
	public Object createDocument(@PathParam("DBName") String DBName, Object document) {
    	cloudant c = new cloudant();
    	c.login();
    	return c.createDocument(DBName,document);
	}
    
/*    @GET
    @Path("getToken")
	@Produces("application/json")
	public BasicAuthInterceptor getToken() {
    	cloudant c = new cloudant();
    	return c.askForToken();    	
	}*/
    
}