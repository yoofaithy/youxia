package com.ibm.ff.rest.services;


import java.io.IOException;
import java.security.NoSuchProviderException;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import org.bouncycastle.openpgp.PGPException;

import com.ibm.ff.pgp.*;
import com.ibm.ff.pgp.PGPRealization.keyalgorithms;
import com.cloudant.http.interceptors.BasicAuthInterceptor;
import com.ibm.ff.dbfactory.*;
import com.ibm.ff.rest.entity.*;
import com.ibm.ff.rest.entity.response.Jobrole;



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
    @Path("genCer/{KeyStoreFileFullName}/{KeyStorePassword}/{CerFileFullName}/{KeyPassword}")
	@Produces("application/json")
	public void genCer(
			@PathParam("KeyStoreFileFullName") String KeyStoreFileFullName,
			@PathParam("KeyStorePassword") String KeyStorePassword,
			@PathParam("CerFileFullName") String CerFileFullName,
			@PathParam("KeyPassword") String KeyPassword) {

    	String keyinfo = "CN=(fyuewen), OU=(ibm), O=(cdl), L=(SH), ST=(SH), C=(CN)";
    	PGPRealization pgp = new PGPRealization();
    	pgp.genKeyStore("test", keyalgorithms.RSA, KeyStoreFileFullName, keyinfo, KeyStorePassword, KeyPassword);
    	pgp.export("test", KeyStoreFileFullName, CerFileFullName, KeyStorePassword);
	}

    @GET
    @Path("encriptfile/{outFileFullName}/{inFileFullName}/{inKeyFileFullName}")
	@Produces("application/json")
	public void encriptFile(
			@PathParam("outFileFullName") String outFileFullName,
			@PathParam("inFileFullName") String inFileFullName,
			@PathParam("inKeyFileFullName") String inKeyFileFullName) {
		try {
			PGPRealization.encryptFile(outFileFullName, inFileFullName, inKeyFileFullName, false, true);
		} catch (NoSuchProviderException | IOException | PGPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

    @GET
    @Path("{DBName}/findjobrole/{JobRoleName}")
	@Produces("application/json")
    public Object findjobrole(@PathParam("DBName") String DBName,@PathParam("JobRoleName") String JobRoleName){
    	cloudant c = new cloudant();
    	c.login();
    	
    	List<com.ibm.ff.rest.entity.cloudant.Jobrole> jobroleList = (List<com.ibm.ff.rest.entity.cloudant.Jobrole>) c.findByFieldName(DBName, "jobRoleName", JobRoleName, "Jobrole");
    	
    	
    	return jobroleList;
    }
    
    @GET
    @Path("{DBName}/regexfindjobrole/{JobRoleName}")
	@Produces("application/json")
    public List<Object> regexfindjobrole(@PathParam("DBName") String DBName,@PathParam("JobRoleName") String JobRoleName){
    	cloudant c = new cloudant();
    	c.login();
    	
    	List<Object> jobroleList = (List<Object>) c.regexFindByFieldName(DBName, "jobRoleName", JobRoleName, "Jobrole");
    	
		
    	return jobroleList;
    }
    
}